package com.personal.usersignup.auth.application;

import com.personal.usersignup.auth.domain.records.read.UserDefinition;
import com.personal.usersignup.auth.domain.records.write.UserRegistration;
import com.personal.usersignup.auth.domain.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterUser {

    private final UserRepository userRepository;

    public RegisterUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDefinition execute(UserRegistration userToRegister) {
        throw new RuntimeException("Not implemented yet");
    }
}
