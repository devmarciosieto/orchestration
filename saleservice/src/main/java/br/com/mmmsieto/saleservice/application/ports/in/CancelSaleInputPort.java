package br.com.mmmsieto.saleservice.application.ports.in;

import br.com.mmmsieto.saleservice.application.core.domain.Sale;

public interface CancelSaleInputPort {

    void cancel(Sale sale);

}
