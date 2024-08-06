package com.personal.usersignup.auth.application;

import com.personal.usersignup.auth.domain.records.read.UserDefinition;
import com.personal.usersignup.auth.domain.records.write.UserRegistration;
import com.personal.usersignup.auth.infrastructure.repositories.UserRepositoryFake;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserTest {

    private UserRepositoryFake userRepositoryFake;
    private final RegisterUser registerUser = new RegisterUser(userRepositoryFake);

    @Test
    void should_register_user() {
        UserRegistration userToRegister = new UserRegistration(
                "fernando@gmail.com",
                "fernando.perera",
                "MyPassW03R"
        );
        UserDefinition expectedUserDefinition = new UserDefinition(
                "fernando@gmail.com",
                "fernando.perera"
        );

        UserDefinition result = registerUser.execute(userToRegister);

        assertEquals(expectedUserDefinition, result);
    }

}