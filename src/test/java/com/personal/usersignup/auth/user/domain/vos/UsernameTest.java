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

}