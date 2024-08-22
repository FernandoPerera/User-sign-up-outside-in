package com.personal.usersignup.auth.infrastructure.repositories;

import com.personal.usersignup.auth.domain.repositories.UserRepository;
import com.personal.usersignup.auth.domain.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryFake implements UserRepository {

    public UserRepositoryFake() {}

    @Override
    public User save(User user) {
        return user;
    }
}
