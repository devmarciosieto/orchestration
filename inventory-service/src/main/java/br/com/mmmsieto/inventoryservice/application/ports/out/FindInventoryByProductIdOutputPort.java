package br.com.mmmsieto.inventoryservice.application.ports.out;

import br.com.mmmsieto.inventoryservice.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> find(Long productId);

}
