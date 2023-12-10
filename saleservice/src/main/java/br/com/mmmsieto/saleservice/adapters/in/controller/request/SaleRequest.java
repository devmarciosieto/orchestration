package br.com.mmmsieto.saleservice.adapters.in.controller.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class SaleRequest {

    @NonNull
    private Long userId;

    @NonNull
    private Long productId;

    @NonNull
    private Long quantity;

    @NonNull
    private BigDecimal price;

}
