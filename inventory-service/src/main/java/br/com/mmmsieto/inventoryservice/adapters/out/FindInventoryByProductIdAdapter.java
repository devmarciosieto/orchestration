package br.com.mmmsieto.inventoryservice.adapters.out;

import br.com.mmmsieto.inventoryservice.adapters.out.repository.InventoryRepository;
import br.com.mmmsieto.inventoryservice.adapters.out.repository.mapper.InventoryEntityMapper;
import br.com.mmmsieto.inventoryservice.application.core.domain.Inventory;
import br.com.mmmsieto.inventoryservice.application.ports.out.FindInventoryByProductIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {


    private final InventoryRepository inventoryRepository;

    public FindInventoryByProductIdAdapter(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }


    @Override
    public Optional<Inventory> find(Long productId) {
        var inventory = inventoryRepository.findByProductId(productId);
        return inventory.map(InventoryEntityMapper::toInventory);
    }

}
