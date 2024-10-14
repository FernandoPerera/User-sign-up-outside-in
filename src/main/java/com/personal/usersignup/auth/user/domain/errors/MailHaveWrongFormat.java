package com.personal.usersignup.auth.user.domain.errors;

import com.personal.usersignup.shared.domain.error.DomainError;

public class MailHaveWrongFormat extends DomainError {

    public MailHaveWrongFormat(String message) {
        super(message);
    }
}
