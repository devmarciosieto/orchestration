package br.com.mmmsieto.paymentservice.application.ports.in;

import br.com.mmmsieto.paymentservice.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(final Long id);

}
