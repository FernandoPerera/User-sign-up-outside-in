package com.personal.usersignup.auth.user.domain.repositories;

import com.personal.usersignup.auth.user.domain.models.User;

public interface UserRepository {
    User save(User user);
}

