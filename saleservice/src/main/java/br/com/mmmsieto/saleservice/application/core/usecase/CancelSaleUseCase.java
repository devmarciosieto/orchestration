package br.com.mmmsieto.saleservice.application.core.usecase;

import br.com.mmmsieto.saleservice.application.core.domain.Sale;
import br.com.mmmsieto.saleservice.application.ports.in.CancelSaleInputPort;
import br.com.mmmsieto.saleservice.application.ports.in.FindSaleByIdInputPort;
import br.com.mmmsieto.saleservice.application.ports.out.SaveSaleOutputPort;

public class CancelSaleUseCase implements CancelSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutputPort saveSaleOutputPort;

    public CancelSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort, SaveSaleOutputPort saveSaleOutputPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void cancel(Sale sale) {
        var saleFound = findSaleByIdInputPort.find(sale.getId());
        saleFound.cancel();
        saveSaleOutputPort.save(saleFound);
    }
}
