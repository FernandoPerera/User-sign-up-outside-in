package com.personal.usersignup.auth.user.domain.errors;

import com.personal.usersignup.shared.domain.error.DomainError;

public class MailCannotBeEmpty extends DomainError {

    private final String message;

    public MailCannotBeEmpty(String message) {
        this.message = message;
    }
}
