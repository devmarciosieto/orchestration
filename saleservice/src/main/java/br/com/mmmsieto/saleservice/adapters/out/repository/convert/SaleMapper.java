package br.com.mmmsieto.saleservice.adapters.out.repository.convert;

import br.com.mmmsieto.saleservice.adapters.out.repository.entity.SaleEntity;
import br.com.mmmsieto.saleservice.application.core.domain.Sale;
import br.com.mmmsieto.saleservice.application.core.domain.enums.SaleStatus;

public interface SaleMapper {

    static Sale toSale(SaleEntity saleEntity) {
        return new Sale(
                saleEntity.getId(),
                saleEntity.getProductId(),
                saleEntity.getUserId(),
                saleEntity.getValue(),
                SaleStatus.fromStatusId(saleEntity.getStatusId()),
                saleEntity.getQuantity()
        );

    }

}

