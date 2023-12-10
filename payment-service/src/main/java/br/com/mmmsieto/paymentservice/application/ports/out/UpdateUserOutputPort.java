package br.com.mmmsieto.paymentservice.application.ports.out;

import br.com.mmmsieto.paymentservice.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);

}
