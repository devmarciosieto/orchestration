package br.com.mmmsieto.orchestrationservice.application.core.usecase;

import br.com.mmmsieto.orchestrationservice.application.core.domain.Sale;
import br.com.mmmsieto.orchestrationservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.orchestrationservice.application.ports.in.WorkflowInputPort;
import br.com.mmmsieto.orchestrationservice.application.ports.out.SendSaleToTopicOutputPort;

public class PaymentExecutedUseCase implements WorkflowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public PaymentExecutedUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        System.out.println("start PaymentExecutedUseCase");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.FINALIZE_SALE, "tp-saga-sale");
        System.out.println("end PaymentExecutedUseCase");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent event) {
        return SaleEvent.PAYMENT_EXECUTED.equals(event);
    }
}
