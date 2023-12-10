package br.com.mmmsieto.orchestrationservice.application.core.usecase;

import br.com.mmmsieto.orchestrationservice.application.core.domain.Sale;
import br.com.mmmsieto.orchestrationservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.orchestrationservice.application.ports.in.WorkflowInputPort;
import br.com.mmmsieto.orchestrationservice.application.ports.out.SendSaleToTopicOutputPort;

public class CreatedSaleUseCase implements WorkflowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public CreatedSaleUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        System.out.println("start of stock separation");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.PREPARE_INVENTORY, "tp-saga-inventory");
        System.out.println("end of stock separation");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent event) {
        return SaleEvent.CREATED_SALE.equals(event);
    }

}
