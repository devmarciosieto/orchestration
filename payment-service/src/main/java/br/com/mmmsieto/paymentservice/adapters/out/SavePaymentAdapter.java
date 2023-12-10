package br.com.mmmsieto.paymentservice.adapters.out;

import br.com.mmmsieto.paymentservice.adapters.out.repository.PaymentRepository;
import br.com.mmmsieto.paymentservice.adapters.out.repository.mapper.PaymentEntityMapper;
import br.com.mmmsieto.paymentservice.application.core.domain.Payment;
import br.com.mmmsieto.paymentservice.application.ports.out.SavePaymentOutputPort;
import org.springframework.stereotype.Component;

@Component
public class SavePaymentAdapter implements SavePaymentOutputPort {

    private final PaymentRepository paymentRepository;

    public SavePaymentAdapter(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(PaymentEntityMapper.toPaymentEntity(payment));
    }

}
