package br.com.mmmsieto.paymentservice.adapters.out.repository.mapper;

import br.com.mmmsieto.paymentservice.adapters.out.repository.entity.PaymentEntity;
import br.com.mmmsieto.paymentservice.application.core.domain.Payment;

public interface PaymentEntityMapper {

    static PaymentEntity toPaymentEntity(Payment payment) {
        return new PaymentEntity(
                payment.getId(),
                payment.getUserId(),
                payment.getSaleId(),
                payment.getValue());
    }

}
