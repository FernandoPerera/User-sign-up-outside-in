package com.personal.usersignup.auth.user.domain.vos;

import com.personal.usersignup.auth.user.domain.errors.UsernameCannotBeEmpty;
import com.personal.usersignup.shared.Result;
import com.personal.usersignup.shared.domain.error.DomainError;

public class Username {

    private String username;

    private Username(String username) {
        this.username = username;
    }

    public static Result<DomainError, Username> of(String username) {
        return Result.error(new UsernameCannotBeEmpty("Username cannot be empty !!"));
    }

}
