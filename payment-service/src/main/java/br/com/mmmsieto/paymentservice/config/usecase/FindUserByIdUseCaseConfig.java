package br.com.mmmsieto.paymentservice.config.usecase;

import br.com.mmmsieto.paymentservice.adapters.out.FindUserByIdAdapter;
import br.com.mmmsieto.paymentservice.application.core.usecase.FindUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByIdUseCaseConfig {

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(FindUserByIdAdapter findUserByIdAdapter) {
        return new FindUserByIdUseCase(findUserByIdAdapter);
    }

}
