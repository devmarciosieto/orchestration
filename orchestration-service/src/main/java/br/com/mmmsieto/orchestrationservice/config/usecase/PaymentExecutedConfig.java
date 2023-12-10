package br.com.mmmsieto.orchestrationservice.config.usecase;

import br.com.mmmsieto.orchestrationservice.adapters.out.SendSaleToTopicAdapter;
import br.com.mmmsieto.orchestrationservice.application.core.usecase.PaymentExecutedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentExecutedConfig {

    @Bean
    public PaymentExecutedUseCase paymentExecutedUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new PaymentExecutedUseCase(sendSaleToTopicAdapter);
    }

}
