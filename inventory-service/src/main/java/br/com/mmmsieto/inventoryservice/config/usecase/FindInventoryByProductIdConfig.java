package br.com.mmmsieto.inventoryservice.config.usecase;

import br.com.mmmsieto.inventoryservice.adapters.out.FindInventoryByProductIdAdapter;
import br.com.mmmsieto.inventoryservice.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindInventoryByProductIdConfig {

    @Bean
    public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(
            FindInventoryByProductIdAdapter findInventoryByProductIdAdapter
    ) {
        return new FindInventoryByProductIdUseCase(findInventoryByProductIdAdapter);
    }

}
