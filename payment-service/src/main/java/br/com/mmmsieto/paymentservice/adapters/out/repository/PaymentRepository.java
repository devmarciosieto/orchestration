package br.com.mmmsieto.paymentservice.adapters.out.repository;

import br.com.mmmsieto.paymentservice.adapters.out.repository.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{
}
