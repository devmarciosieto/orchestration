package br.com.mmmsieto.orchestrationservice.config.usecase;

import br.com.mmmsieto.orchestrationservice.adapters.out.SendSaleToTopicAdapter;
import br.com.mmmsieto.orchestrationservice.application.core.usecase.PaymentFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentFailureConfig {

    @Bean
    public PaymentFailureUseCase paymentFailureUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new PaymentFailureUseCase(sendSaleToTopicAdapter);
    }

}
