package br.com.mmmsieto.inventoryservice.config.usecase;

import br.com.mmmsieto.inventoryservice.adapters.out.UpdateInventoryAdapter;
import br.com.mmmsieto.inventoryservice.application.core.usecase.CreditInventoryUseCase;
import br.com.mmmsieto.inventoryservice.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryUseCaseConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter) {
        return new CreditInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter);
    }

}
