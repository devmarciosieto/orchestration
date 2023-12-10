package br.com.mmmsieto.orchestrationservice.application.core.usecase;

import br.com.mmmsieto.orchestrationservice.application.core.domain.Sale;
import br.com.mmmsieto.orchestrationservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.orchestrationservice.application.ports.in.WorkflowInputPort;
import br.com.mmmsieto.orchestrationservice.application.ports.out.SendSaleToTopicOutputPort;

public class InventoryPreparedUseCase implements WorkflowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public InventoryPreparedUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        System.out.println("start send sale to topic: tp-saga-payment");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.EXECUTE_PAYMENT, "tp-saga-payment");
        System.out.println("end sale sent to topic: tp-saga-payment");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent event) {
        return SaleEvent.INVENTORY_PREPARED.equals(event);
    }

}
