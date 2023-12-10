package br.com.mmmsieto.saleservice.application.ports.out;

import br.com.mmmsieto.saleservice.application.core.domain.Sale;
import br.com.mmmsieto.saleservice.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale sale, SaleEvent event);

}
