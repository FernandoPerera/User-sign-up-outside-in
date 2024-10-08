package com.personal.usersignup.auth.application;

import com.personal.usersignup.auth.user.infrastructure.security.FakeAuthenticationTokenHandler;
import com.personal.usersignup.auth.user.application.RegisterUser;
import com.personal.usersignup.auth.user.domain.records.read.UserDefinition;
import com.personal.usersignup.auth.user.domain.records.write.UserRegistration;
import com.personal.usersignup.auth.user.infrastructure.repositories.UserRepositoryFake;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserTest {

    private final UserRepositoryFake userRepositoryFake = new UserRepositoryFake();
    private final RegisterUser registerUser = new RegisterUser(userRepositoryFake);

    private final UserRegistration userToRegister = new UserRegistration(
            "fernando@gmail.com",
            "fernando.perera",
            "MyPassW03R"
    );

    @Test
    void should_register_user() {
        String token = FakeAuthenticationTokenHandler.generateToken();
        UserDefinition expectedUserDefinition = new UserDefinition(
                userToRegister.username(),
                token
        );

        registerUser.execute(userToRegister).map(
                error -> {
                    assertNull(error);
                    return null;
                },
                userDefinition -> {
                    assertEquals(expectedUserDefinition, userDefinition);
                    return null;
                }
        );
    }

}