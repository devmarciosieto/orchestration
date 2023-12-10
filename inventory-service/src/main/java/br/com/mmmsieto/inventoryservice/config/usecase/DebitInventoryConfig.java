package br.com.mmmsieto.inventoryservice.config.usecase;

import br.com.mmmsieto.inventoryservice.adapters.out.SendToKafkaAdapter;
import br.com.mmmsieto.inventoryservice.adapters.out.UpdateInventoryAdapter;
import br.com.mmmsieto.inventoryservice.application.core.usecase.DebitInventoryUseCase;
import br.com.mmmsieto.inventoryservice.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ) {
        return new DebitInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter, sendToKafkaAdapter);
    }

}
