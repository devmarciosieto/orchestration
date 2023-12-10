package br.com.mmmsieto.saleservice.adapters.out.message;

import br.com.mmmsieto.saleservice.application.core.domain.Sale;
import br.com.mmmsieto.saleservice.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {

    private Sale sale;

    private SaleEvent event;

}

