package br.com.mmmsieto.inventoryservice.application.ports.in;

import br.com.mmmsieto.inventoryservice.application.core.domain.Sale;

public interface DebitInventoryInputPort {

    void debit(Sale sale);

}
