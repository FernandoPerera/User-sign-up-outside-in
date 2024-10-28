package com.personal.usersignup.auth.user.domain.vos;

import com.personal.usersignup.auth.user.domain.errors.MailCannotBeEmpty;
import com.personal.usersignup.auth.user.domain.errors.MailHaveWrongFormat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailTest {

    // empty string -> domain error
    // wrong format -> domain error
    // correct format -> create mail

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

    @Test
    void should_not_create_mail_if_have_wrong_format() {
        String content = "testcom";

        Mail.of(content).map(
                error -> assertInstanceOf(MailHaveWrongFormat.class, error),
                mail -> {
                    assertNull(mail);
                    return null;
                }
        );
    }

    @Test
    void should_create_mail() {
        String content = "test@company.es";

        Mail.of(content).map(
                error -> {
                    assertNull(error);
                    return null;
                },
                mail -> {
                    assertEquals(content, mail.getValue());
                    return mail;
                }
        );
    }
}