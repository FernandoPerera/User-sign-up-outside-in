package com.personal.usersignup.auth.user.domain.errors;

import com.personal.usersignup.shared.domain.error.DomainError;

public class MailCannotBeEmpty extends DomainError {

    public MailCannotBeEmpty(String message) {
        super(message);
    }
}
