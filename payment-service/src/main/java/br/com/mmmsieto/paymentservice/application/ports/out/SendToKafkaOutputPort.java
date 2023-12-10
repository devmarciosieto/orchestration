package br.com.mmmsieto.paymentservice.application.ports.out;

import br.com.mmmsieto.paymentservice.application.core.domain.Sale;
import br.com.mmmsieto.paymentservice.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);

}
