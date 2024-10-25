package com.personal.usersignup.auth.user.domain.vos;

import com.personal.usersignup.shared.Result;
import com.personal.usersignup.shared.domain.error.DomainError;

public class Username {

    private String username;

    private Username(String username) {
        this.username = username;
    }

    public static Result<DomainError, Username> of(String username) {
        throw new RuntimeException("Not implemented yet");
    }

}
