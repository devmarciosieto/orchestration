package br.com.mmmsieto.orchestrationservice.application.ports.out;

import br.com.mmmsieto.orchestrationservice.application.core.domain.Sale;
import br.com.mmmsieto.orchestrationservice.application.core.domain.enums.SaleEvent;

public interface SendSaleToTopicOutputPort {

    void send(Sale sale, SaleEvent event, String topic);

}
