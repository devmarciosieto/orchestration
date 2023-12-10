package br.com.mmmsieto.saleservice.application.ports.in;

import br.com.mmmsieto.saleservice.application.core.domain.Sale;

public interface FinalizeSaleInputPort {

    void finalizeSale(Sale sale);

}
