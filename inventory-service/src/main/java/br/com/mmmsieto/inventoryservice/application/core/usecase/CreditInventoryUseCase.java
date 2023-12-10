package br.com.mmmsieto.inventoryservice.application.core.usecase;

import br.com.mmmsieto.inventoryservice.application.core.domain.Sale;
import br.com.mmmsieto.inventoryservice.application.ports.in.CreditInventoryInputPort;
import br.com.mmmsieto.inventoryservice.application.ports.in.FindInventoryByProductIdInputPort;
import br.com.mmmsieto.inventoryservice.application.ports.out.UpdateInventoryOutputPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;

    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    public CreditInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                  UpdateInventoryOutputPort updateInventoryOutputPort){
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
    }

    @Override
    public void credit(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);

    }


}
