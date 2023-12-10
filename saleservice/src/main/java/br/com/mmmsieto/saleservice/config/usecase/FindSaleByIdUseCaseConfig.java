package br.com.mmmsieto.saleservice.config.usecase;

import br.com.mmmsieto.saleservice.adapters.out.FindSaleByAdapters;
import br.com.mmmsieto.saleservice.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdUseCaseConfig {

    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(FindSaleByAdapters findSaleByAdapters) {
        return new FindSaleByIdUseCase(findSaleByAdapters);
    }

}
