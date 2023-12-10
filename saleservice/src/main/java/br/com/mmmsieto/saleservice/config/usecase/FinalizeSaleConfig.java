package br.com.mmmsieto.saleservice.config.usecase;

import br.com.mmmsieto.saleservice.adapters.out.SaveSaleAdapter;
import br.com.mmmsieto.saleservice.application.core.usecase.FinalizeSaleUseCase;
import br.com.mmmsieto.saleservice.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizeSaleConfig {

    @Bean
    public FinalizeSaleUseCase finalizeSaleInputPort(FindSaleByIdUseCase findSaleByIdUseCase,
                                                     SaveSaleAdapter saveSaleAdapter) {
      return new FinalizeSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }

}
