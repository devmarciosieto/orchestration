package br.com.mmmsieto.inventoryservice.adapters.out;

import br.com.mmmsieto.inventoryservice.adapters.out.repository.InventoryRepository;
import br.com.mmmsieto.inventoryservice.adapters.out.repository.mapper.InventoryEntityMapper;
import br.com.mmmsieto.inventoryservice.application.core.domain.Inventory;
import br.com.mmmsieto.inventoryservice.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    private final InventoryRepository repository;

    public UpdateInventoryAdapter(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void update(Inventory inventory) {
        repository.save(InventoryEntityMapper.toInventoryEntity(inventory));
    }
}
