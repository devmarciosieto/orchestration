package br.com.mmmsieto.saleservice.adapters.out;

import br.com.mmmsieto.saleservice.adapters.out.message.SaleMessage;
import br.com.mmmsieto.saleservice.application.core.domain.Sale;
import br.com.mmmsieto.saleservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.saleservice.application.ports.out.SendCreatedSaleOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCreatedSaleAdapter implements SendCreatedSaleOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-orchestrator", saleMessage);
    }

}
