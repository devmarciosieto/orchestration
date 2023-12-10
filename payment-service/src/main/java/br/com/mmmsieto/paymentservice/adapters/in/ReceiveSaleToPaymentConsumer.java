package br.com.mmmsieto.paymentservice.adapters.in;

import br.com.mmmsieto.paymentservice.adapters.out.message.SaleMessage;
import br.com.mmmsieto.paymentservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.paymentservice.application.ports.in.SalePaymentInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToPaymentConsumer {

    private final SalePaymentInputPort salePaymentInputPort;

    public ReceiveSaleToPaymentConsumer(SalePaymentInputPort salePaymentInputPort) {
        this.salePaymentInputPort = salePaymentInputPort;
    }

    @KafkaListener(topics = "tp-saga-payment", groupId = "payment")
    public void receive(SaleMessage saleMessage) {
        log.info("Sale received: {}", saleMessage);

        if (SaleEvent.EXECUTE_PAYMENT.equals(saleMessage.getEvent())) {
            log.info("Start Sale event: {}", saleMessage.getEvent());
            salePaymentInputPort.payment(saleMessage.getSale());
            log.info("End Sale event: {}", saleMessage.getEvent());
        }

    }

}
