package br.com.mmmsieto.paymentservice.application.ports.in;

import br.com.mmmsieto.paymentservice.application.core.domain.Sale;

public interface SalePaymentInputPort {
    void payment(Sale sale);
}
