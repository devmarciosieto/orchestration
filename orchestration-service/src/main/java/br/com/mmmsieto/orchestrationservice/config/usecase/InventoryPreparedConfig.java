package br.com.mmmsieto.orchestrationservice.config.usecase;

import br.com.mmmsieto.orchestrationservice.adapters.out.SendSaleToTopicAdapter;
import br.com.mmmsieto.orchestrationservice.application.core.usecase.InventoryPreparedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryPreparedConfig {

    @Bean
    public InventoryPreparedUseCase inventoryPreparedUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new InventoryPreparedUseCase(sendSaleToTopicAdapter);
    }

}
