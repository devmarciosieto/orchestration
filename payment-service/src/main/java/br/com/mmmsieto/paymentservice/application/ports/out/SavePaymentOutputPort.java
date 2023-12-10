package br.com.mmmsieto.paymentservice.application.ports.out;

import br.com.mmmsieto.paymentservice.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save(Payment payment);

}
