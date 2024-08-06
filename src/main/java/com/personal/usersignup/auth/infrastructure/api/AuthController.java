package com.personal.usersignup.auth.infrastructure.api;

import com.personal.usersignup.auth.application.RegisterUser;
import com.personal.usersignup.auth.domain.records.read.UserDefinition;
import com.personal.usersignup.auth.domain.records.write.UserRegistration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final RegisterUser registerUser;

    public AuthController(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @PostMapping("/sign_up")
    public ResponseEntity<UserDefinition> signUp(@RequestBody UserRegistration userToRegister) {
        return new ResponseEntity<>(
                registerUser.execute(userToRegister),
                HttpStatus.CREATED
        );
    }
}
