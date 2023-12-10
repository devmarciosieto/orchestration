package br.com.mmmsieto.paymentservice.application.ports.out;

import br.com.mmmsieto.paymentservice.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> find(Long id);

}
