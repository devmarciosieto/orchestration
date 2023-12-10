package br.com.mmmsieto.saleservice.application.ports.out;

import br.com.mmmsieto.saleservice.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale sale);

}
