package com.personal.usersignup.auth.user.domain.vos;

import com.personal.usersignup.auth.user.domain.errors.MailCannotBeEmpty;
import com.personal.usersignup.shared.Result;
import com.personal.usersignup.shared.domain.error.DomainError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailTest {

    // empty string -> domain error

    @Test
    void should_not_create_mail_if_content_is_empty() {
        String content = "";

        Mail.of(content).map(
                error -> assertInstanceOf(MailCannotBeEmpty.class, error),
                mail -> {
                    assertNull(mail);
                    return null;
                }
        );
    }

}