package br.com.mmmsieto.saleservice.application.ports.in;

import br.com.mmmsieto.saleservice.application.core.domain.Sale;

public interface CreateSaleInputPort {

    void create(Sale sale);

}
