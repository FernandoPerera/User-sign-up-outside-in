package com.personal.usersignup.auth.user.domain.errors;

import com.personal.usersignup.shared.domain.error.DomainError;

public class MailHaveWrongFormat extends DomainError {

    private final String message;

    public MailHaveWrongFormat(String message) {
        this.message = message;
    }
}
