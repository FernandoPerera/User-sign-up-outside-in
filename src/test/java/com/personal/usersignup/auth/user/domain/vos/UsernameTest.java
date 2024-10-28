package com.personal.usersignup.auth.user.domain.vos;

import com.personal.usersignup.auth.user.domain.errors.UsernameCannotBeEmpty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsernameTest {

    @Test
    void should_not_be_empty() {
        String usernameEntry = "";
        
        Username.of(usernameEntry).map(
                domainError -> {
                    assertInstanceOf(UsernameCannotBeEmpty.class, domainError);
                    return domainError;
                },
                username -> {
                    assertNull(username);
                    return username;
                }
        );
    }

    @Test
    void should_create_username() {
        String usernameEntry = "user.name";

        Username.of(usernameEntry).map(
                domainError -> {
                    assertNull(domainError);
                    return domainError;
                },
                username -> {
                    assertEquals("user.name", username.getValue());
                    return username;
                }
        );
    }

}