package br.com.mmmsieto.saleservice.config.usecase;

import br.com.mmmsieto.saleservice.adapters.out.SaveSaleAdapter;
import br.com.mmmsieto.saleservice.application.core.usecase.CancelSaleUseCase;
import br.com.mmmsieto.saleservice.application.core.usecase.FindSaleByIdUseCase;
import br.com.mmmsieto.saleservice.application.ports.in.CancelSaleInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleInputPort cancelSaleInputPort(FindSaleByIdUseCase findSaleByIdUseCase,
                                                   SaveSaleAdapter saveSaleAdapter) {
        return new CancelSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }

}
