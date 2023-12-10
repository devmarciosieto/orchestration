package br.com.mmmsieto.saleservice.config.usecase;

import br.com.mmmsieto.saleservice.adapters.out.SaveSaleAdapter;
import br.com.mmmsieto.saleservice.adapters.out.SendCreatedSaleAdapter;
import br.com.mmmsieto.saleservice.application.core.usecase.CreateSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(
            SaveSaleAdapter saveSaleAdapter,
            SendCreatedSaleAdapter sendCreatedSaleAdapter) {
        return new CreateSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }

}
