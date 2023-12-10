package br.com.mmmsieto.inventoryservice.application.ports.in;

import br.com.mmmsieto.inventoryservice.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(Long productId);

}
