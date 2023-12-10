package br.com.mmmsieto.saleservice.application.core.usecase;

import br.com.mmmsieto.saleservice.application.core.domain.Sale;
import br.com.mmmsieto.saleservice.application.core.domain.enums.SaleStatus;
import br.com.mmmsieto.saleservice.application.ports.in.FinalizeSaleInputPort;
import br.com.mmmsieto.saleservice.application.ports.in.FindSaleByIdInputPort;
import br.com.mmmsieto.saleservice.application.ports.out.SaveSaleOutputPort;

public class FinalizeSaleUseCase implements FinalizeSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutputPort saveSaleOutputPort;

    public FinalizeSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort,
                               SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void finalizeSale(Sale sale) {
        var saleResponse = findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.FINISHED);
        saveSaleOutputPort.save(saleResponse);
    }

}
