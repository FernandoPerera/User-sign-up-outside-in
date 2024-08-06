package com.personal.usersignup.auth.application;

import com.personal.usersignup.auth.domain.records.write.UserRegistration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterUser {

    public ResponseEntity<Object> execute(UserRegistration userToRegister) {
        throw new RuntimeException("Not implemented yet");
    }
}
