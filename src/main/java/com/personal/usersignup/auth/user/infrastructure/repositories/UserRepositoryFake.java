package com.personal.usersignup.auth.user.infrastructure.repositories;

import com.personal.usersignup.auth.user.domain.repositories.UserRepository;
import com.personal.usersignup.auth.user.domain.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryFake implements UserRepository {

    public UserRepositoryFake() {}

    @Override
    public User save(User user) {
        return user;
    }
}
