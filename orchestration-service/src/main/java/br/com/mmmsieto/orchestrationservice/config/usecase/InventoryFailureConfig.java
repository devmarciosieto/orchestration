package br.com.mmmsieto.orchestrationservice.config.usecase;

import br.com.mmmsieto.orchestrationservice.adapters.out.SendSaleToTopicAdapter;
import br.com.mmmsieto.orchestrationservice.application.core.usecase.InventoryFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryFailureConfig {

    @Bean
    public InventoryFailureUseCase inventoryFailureUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new InventoryFailureUseCase(sendSaleToTopicAdapter);
    }

}
