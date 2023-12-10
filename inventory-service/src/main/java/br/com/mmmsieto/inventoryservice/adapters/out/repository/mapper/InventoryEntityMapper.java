package br.com.mmmsieto.inventoryservice.adapters.out.repository.mapper;

import br.com.mmmsieto.inventoryservice.adapters.out.repository.entity.InventoryEntity;
import br.com.mmmsieto.inventoryservice.application.core.domain.Inventory;

public interface InventoryEntityMapper {

    static Inventory toInventory(InventoryEntity entity) {
        return new Inventory(
            entity.getId(),
            entity.getProductId(),
            entity.getQuantity()
        );
    }

    static InventoryEntity toInventoryEntity(Inventory inventory) {
        return new InventoryEntity(
            inventory.getId(),
            inventory.getProductId(),
            inventory.getQuantity()
        );
    }

}
