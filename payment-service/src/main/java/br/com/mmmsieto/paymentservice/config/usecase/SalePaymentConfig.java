package br.com.mmmsieto.paymentservice.config.usecase;

import br.com.mmmsieto.paymentservice.adapters.out.SavePaymentAdapter;
import br.com.mmmsieto.paymentservice.adapters.out.SendToKafkaAdapter;
import br.com.mmmsieto.paymentservice.adapters.out.UpdateUserAdapter;
import br.com.mmmsieto.paymentservice.application.core.usecase.FindUserByIdUseCase;
import br.com.mmmsieto.paymentservice.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(FindUserByIdUseCase findUserByIdUseCase,
                                                 UpdateUserAdapter updateUserAdapter,
                                                 SavePaymentAdapter savePaymentAdapter,
                                                 SendToKafkaAdapter sendToKafkaAdapter) {
        return new SalePaymentUseCase(findUserByIdUseCase,
                updateUserAdapter,
                savePaymentAdapter,
                sendToKafkaAdapter);
    }

}
