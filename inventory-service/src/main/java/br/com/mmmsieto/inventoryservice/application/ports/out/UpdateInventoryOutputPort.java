package br.com.mmmsieto.inventoryservice.application.ports.out;

import br.com.mmmsieto.inventoryservice.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);

}
