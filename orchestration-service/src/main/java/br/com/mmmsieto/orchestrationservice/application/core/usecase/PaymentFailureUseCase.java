package br.com.mmmsieto.orchestrationservice.application.core.usecase;

import br.com.mmmsieto.orchestrationservice.application.core.domain.Sale;
import br.com.mmmsieto.orchestrationservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.orchestrationservice.application.ports.in.WorkflowInputPort;
import br.com.mmmsieto.orchestrationservice.application.ports.out.SendSaleToTopicOutputPort;

public class PaymentFailureUseCase implements WorkflowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public PaymentFailureUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        System.out.println("start PaymentFailureUseCase");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.EXECUTE_ROLLBACK, "tp-saga-inventory");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE, "tp-saga-sale");
        System.out.println("end PaymentFailureUseCase");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent event) {
        return SaleEvent.PAYMENT_FAILED.equals(event);
    }
}
