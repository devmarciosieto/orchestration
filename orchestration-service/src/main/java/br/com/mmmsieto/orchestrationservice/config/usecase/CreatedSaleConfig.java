package br.com.mmmsieto.orchestrationservice.config.usecase;

import br.com.mmmsieto.orchestrationservice.adapters.out.SendSaleToTopicAdapter;
import br.com.mmmsieto.orchestrationservice.application.core.usecase.CreatedSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatedSaleConfig {

    @Bean
    public CreatedSaleUseCase createdSaleUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new CreatedSaleUseCase(sendSaleToTopicAdapter);
    }

}
