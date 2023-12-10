package br.com.mmmsieto.paymentservice.adapters.out;

import br.com.mmmsieto.paymentservice.adapters.out.message.SaleMessage;
import br.com.mmmsieto.paymentservice.application.core.domain.Sale;
import br.com.mmmsieto.paymentservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.paymentservice.application.ports.out.SendToKafkaOutputPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    public SendToKafkaAdapter(KafkaTemplate<String, SaleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-orchestrator", saleMessage);
    }

}
