package br.com.mmmsieto.paymentservice.adapters.out.repository.mapper;

import br.com.mmmsieto.paymentservice.adapters.out.repository.entity.UserEntity;
import br.com.mmmsieto.paymentservice.application.core.domain.User;

public interface UserEntityMapper {

    static User toUser(UserEntity userEntity) {
        return new User(userEntity.getId(),
                userEntity.getName(),
                userEntity.getBalance());
    }

    static UserEntity toUserEntity(User user) {
        return new UserEntity(user.getId(),
                user.getName(),
                user.getBalance());
    }

}
