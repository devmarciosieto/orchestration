package br.com.mmmsieto.saleservice.adapters.in.consumer;

import br.com.mmmsieto.saleservice.adapters.out.message.SaleMessage;
import br.com.mmmsieto.saleservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.saleservice.application.ports.in.CancelSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CancelSaleConsumer {

    private final CancelSaleInputPort cancelSaleInputPort;

    public CancelSaleConsumer(CancelSaleInputPort cancelSaleInputPort) {
        this.cancelSaleInputPort = cancelSaleInputPort;
    }

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-cancel")
    public void receive(SaleMessage saleMessage) {
        log.info("received saleId='{}'", saleMessage);

        if(SaleEvent.CANCEL_SALE.equals(saleMessage.getEvent())) {
            log.info("Start rollback inventory saleId='{}'", saleMessage);
            cancelSaleInputPort.cancel(saleMessage.getSale());
            log.info("End rollback inventory saleId='{}'", saleMessage);
        }

    }

}
