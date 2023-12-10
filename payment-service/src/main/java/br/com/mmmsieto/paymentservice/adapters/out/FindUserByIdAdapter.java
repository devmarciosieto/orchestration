package br.com.mmmsieto.paymentservice.adapters.out;

import br.com.mmmsieto.paymentservice.adapters.out.repository.mapper.UserEntityMapper;
import br.com.mmmsieto.paymentservice.application.core.domain.User;
import br.com.mmmsieto.paymentservice.application.ports.out.FindUserByIdOutputPort;
import br.com.mmmsieto.paymentservice.adapters.out.repository.UserRepository;

import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    private final UserRepository userRepository;

    public FindUserByIdAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> find(Long id) {
        return userRepository.findById(id).map(UserEntityMapper::toUser);
    }
}
