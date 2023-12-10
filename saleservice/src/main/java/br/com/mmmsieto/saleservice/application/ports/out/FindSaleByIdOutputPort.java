package br.com.mmmsieto.saleservice.application.ports.out;

import br.com.mmmsieto.saleservice.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(final Long id);

}
