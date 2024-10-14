package com.personal.usersignup.shared.domain.error;

import com.personal.usersignup.shared.Error;

public abstract class DomainError extends Error {
    private final String message;

    public DomainError(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
