package com.personal.usersignup.auth.user.domain.errors;

import com.personal.usersignup.shared.domain.error.DomainError;

public class UsernameCannotBeEmpty extends DomainError {

    public UsernameCannotBeEmpty(String message) {
        super(message);
    }
}
