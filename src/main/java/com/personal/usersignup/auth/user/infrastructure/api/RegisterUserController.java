package com.personal.usersignup.auth.user.infrastructure.api;

import com.personal.usersignup.auth.user.application.RegisterUser;
import com.personal.usersignup.auth.user.domain.records.read.UserDefinition;
import com.personal.usersignup.auth.user.domain.records.write.UserRegistration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegisterUserController {

    private final RegisterUser registerUser;

    public RegisterUserController(RegisterUser registerUser) {
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
