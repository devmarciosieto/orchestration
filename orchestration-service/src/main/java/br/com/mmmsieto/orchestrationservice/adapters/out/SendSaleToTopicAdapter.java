package br.com.mmmsieto.orchestrationservice.adapters.out;

import br.com.mmmsieto.orchestrationservice.adapters.out.message.SaleMessage;
import br.com.mmmsieto.orchestrationservice.application.core.domain.Sale;
import br.com.mmmsieto.orchestrationservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.orchestrationservice.application.ports.out.SendSaleToTopicOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendSaleToTopicAdapter implements SendSaleToTopicOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event, String topic) {

        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send(topic, saleMessage);
    }
}
