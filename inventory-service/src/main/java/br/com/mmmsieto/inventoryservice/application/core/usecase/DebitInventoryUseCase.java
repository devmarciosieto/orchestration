package br.com.mmmsieto.inventoryservice.application.core.usecase;

import br.com.mmmsieto.inventoryservice.application.core.domain.Sale;
import br.com.mmmsieto.inventoryservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.inventoryservice.application.ports.in.DebitInventoryInputPort;
import br.com.mmmsieto.inventoryservice.application.ports.in.FindInventoryByProductIdInputPort;
import br.com.mmmsieto.inventoryservice.application.ports.out.SendToKafkaOutputPort;
import br.com.mmmsieto.inventoryservice.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase implements DebitInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    private final SendToKafkaOutputPort sendToKafkaOutputPort;


    public DebitInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                 UpdateInventoryOutputPort updateInventoryOutputPort,
                                 SendToKafkaOutputPort sendToKafkaOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void debit(Sale sale) {

        try {
            var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
            if (inventory.getQuantity() < sale.getQuantity()) {
                throw new RuntimeException("Insufficient inventory");
            }
            inventory.debitQuantity(sale.getQuantity());
            updateInventoryOutputPort.update(inventory);
            sendToKafkaOutputPort.send(sale, SaleEvent.INVENTORY_PREPARED);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sendToKafkaOutputPort.send(sale, SaleEvent.INVENTORY_ERROR);
        }

    }

}
