package br.com.mmmsieto.saleservice.adapters.out;


import br.com.mmmsieto.saleservice.adapters.out.repository.SaleRepository;
import br.com.mmmsieto.saleservice.adapters.out.repository.convert.SaleMapper;
import br.com.mmmsieto.saleservice.application.core.domain.Sale;
import br.com.mmmsieto.saleservice.application.ports.out.FindSaleByIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindSaleByAdapters implements FindSaleByIdOutputPort {


    private final SaleRepository saleRepository;

    public FindSaleByAdapters(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Optional<Sale> find(Long id) {
        var sale = saleRepository.findById(id);
        return sale.map(SaleMapper::toSale);
    }

}
