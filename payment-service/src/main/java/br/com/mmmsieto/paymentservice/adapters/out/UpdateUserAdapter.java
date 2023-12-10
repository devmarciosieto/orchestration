package br.com.mmmsieto.paymentservice.adapters.out;

import br.com.mmmsieto.paymentservice.adapters.out.repository.UserRepository;
import br.com.mmmsieto.paymentservice.adapters.out.repository.mapper.UserEntityMapper;
import br.com.mmmsieto.paymentservice.application.core.domain.User;
import br.com.mmmsieto.paymentservice.application.ports.out.UpdateUserOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserAdapter implements UpdateUserOutputPort {

    private final UserRepository userRepository;

    public UpdateUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void update(User user) {

        userRepository.save(UserEntityMapper.toUserEntity(user));

    }
}
