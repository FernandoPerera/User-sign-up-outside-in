package com.personal.usersignup.auth.user.infrastructure.security;

import java.util.UUID;

public class FakeAuthenticationTokenHandler {

    private static final String FAKE_TOKEN = UUID.randomUUID().toString();

    public static String generateToken(){
        return FAKE_TOKEN;
    };
}
