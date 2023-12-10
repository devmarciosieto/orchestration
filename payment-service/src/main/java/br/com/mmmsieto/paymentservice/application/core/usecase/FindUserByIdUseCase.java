package br.com.mmmsieto.paymentservice.application.core.usecase;

import br.com.mmmsieto.paymentservice.application.core.domain.User;
import br.com.mmmsieto.paymentservice.application.ports.in.FindUserByIdInputPort;
import br.com.mmmsieto.paymentservice.application.ports.out.FindUserByIdOutputPort;

public class FindUserByIdUseCase implements FindUserByIdInputPort {

    private final FindUserByIdOutputPort outputPort;

    public FindUserByIdUseCase(FindUserByIdOutputPort outputPort) {
        this.outputPort = outputPort;
    }


    @Override
    public User find(final Long id) {
        return outputPort.find(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
