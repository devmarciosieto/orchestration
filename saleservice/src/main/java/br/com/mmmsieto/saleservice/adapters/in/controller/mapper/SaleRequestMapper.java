package br.com.mmmsieto.saleservice.adapters.in.controller.mapper;

import br.com.mmmsieto.saleservice.adapters.in.controller.request.SaleRequest;
import br.com.mmmsieto.saleservice.application.core.domain.Sale;

public interface SaleRequestMapper {

    static Sale toSale(SaleRequest saleRequest) {
        return new Sale(
                saleRequest.getProductId(),
                saleRequest.getUserId(),
                saleRequest.getPrice(),
                saleRequest.getQuantity());
    }

}

