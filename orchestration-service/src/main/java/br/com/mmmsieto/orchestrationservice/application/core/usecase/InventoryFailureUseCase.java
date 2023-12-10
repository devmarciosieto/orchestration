package br.com.mmmsieto.orchestrationservice.application.core.usecase;

import br.com.mmmsieto.orchestrationservice.application.core.domain.Sale;
import br.com.mmmsieto.orchestrationservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.orchestrationservice.application.ports.in.WorkflowInputPort;
import br.com.mmmsieto.orchestrationservice.application.ports.out.SendSaleToTopicOutputPort;

public class InventoryFailureUseCase implements WorkflowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public InventoryFailureUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        System.out.println("start InventoryFailureUseCase");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE, "tp-saga-sale");
        System.out.println("end InventoryFailureUseCase");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent event) {
        return SaleEvent.INVENTORY_ERROR.equals(event);
    }
}
