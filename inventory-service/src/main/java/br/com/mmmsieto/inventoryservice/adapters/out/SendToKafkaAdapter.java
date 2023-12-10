package br.com.mmmsieto.inventoryservice.adapters.out;

import br.com.mmmsieto.inventoryservice.adapters.out.message.SaleMessage;
import br.com.mmmsieto.inventoryservice.application.core.domain.Sale;
import br.com.mmmsieto.inventoryservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.inventoryservice.application.ports.out.SendToKafkaOutputPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    public SendToKafkaAdapter(KafkaTemplate<String, SaleMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send("tp-saga-orchestrator", saleMessage);
    }
}
