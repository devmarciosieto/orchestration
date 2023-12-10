package br.com.mmmsieto.inventoryservice.application.core.usecase;

import br.com.mmmsieto.inventoryservice.application.core.domain.Inventory;
import br.com.mmmsieto.inventoryservice.application.ports.in.FindInventoryByProductIdInputPort;
import br.com.mmmsieto.inventoryservice.application.ports.out.FindInventoryByProductIdOutputPort;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInventoryByProductIdUseCase(
            FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort
    ) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }

    @Override
    public Inventory find(Long productId) {
        return findInventoryByProductIdOutputPort.find(productId).orElseThrow(() -> new RuntimeException("Inventory not found"));
    }

}
