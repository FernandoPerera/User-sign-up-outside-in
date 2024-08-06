package com.personal.usersignup.auth.domain.repositories;

import com.personal.usersignup.auth.domain.models.User;

public interface UserRepository {
    User save(User user);
}

