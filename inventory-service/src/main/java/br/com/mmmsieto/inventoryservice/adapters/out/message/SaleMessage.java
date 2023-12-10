package br.com.mmmsieto.inventoryservice.adapters.out.message;

import br.com.mmmsieto.inventoryservice.application.core.domain.Sale;
import br.com.mmmsieto.inventoryservice.application.core.domain.enums.SaleEvent;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleMessage {

    private Sale sale;

    private SaleEvent event;

}
