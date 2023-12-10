package br.com.mmmsieto.saleservice.adapters.in.consumer;

import br.com.mmmsieto.saleservice.adapters.out.message.SaleMessage;
import br.com.mmmsieto.saleservice.application.core.domain.enums.SaleEvent;
import br.com.mmmsieto.saleservice.application.ports.in.FinalizeSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToFinalizeConsumer {

    private final FinalizeSaleInputPort finalizeSaleInputPort;

    public ReceiveSaleToFinalizeConsumer(FinalizeSaleInputPort finalizeSaleInputPort) {
        this.finalizeSaleInputPort = finalizeSaleInputPort;
    }

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-finalize")
    public void receive(SaleMessage saleMessage) {
        log.info("Sale received to finalize: {}", saleMessage);

        if (SaleEvent.FINALIZE_SALE.equals(saleMessage.getEvent())) {
            log.info("Start Sale finalized: {}", saleMessage);
            finalizeSaleInputPort.finalizeSale(saleMessage.getSale());
            log.info("End Sale finalized: {}", saleMessage);
        }

    }

}
