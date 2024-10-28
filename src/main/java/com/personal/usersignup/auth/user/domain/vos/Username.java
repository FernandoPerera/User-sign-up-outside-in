package com.personal.usersignup.auth.user.domain.vos;

import com.personal.usersignup.auth.user.domain.errors.UsernameCannotBeEmpty;
import com.personal.usersignup.shared.Result;
import com.personal.usersignup.shared.domain.error.DomainError;

public class Username {

    private final String value;

    private Username(String value) {
        this.value = value;
    }

    public static Result<DomainError, Username> of(String username) {

        if (username.isBlank()) {
            return Result.error(new UsernameCannotBeEmpty("Username cannot be empty !!"));
        }

        return Result.success(new Username(username));
    }

    public String getValue() {
        return value;
    }
}
