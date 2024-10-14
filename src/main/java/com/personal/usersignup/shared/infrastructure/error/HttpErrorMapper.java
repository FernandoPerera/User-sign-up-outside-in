package com.personal.usersignup.shared.infrastructure.error;

import com.personal.usersignup.auth.user.domain.errors.MailCannotBeEmpty;
import com.personal.usersignup.auth.user.domain.errors.MailHaveWrongFormat;
import com.personal.usersignup.shared.domain.error.DomainError;
import org.springframework.http.HttpStatus;

public class HttpErrorMapper {

    public static HttpStatus resolve(DomainError error) {

        return switch (error) {
            case MailCannotBeEmpty mail -> HttpStatus.BAD_REQUEST;
            case MailHaveWrongFormat mail -> HttpStatus.BAD_REQUEST;
            default -> HttpStatus.INTERNAL_SERVER_ERROR;
        };
    }
}
