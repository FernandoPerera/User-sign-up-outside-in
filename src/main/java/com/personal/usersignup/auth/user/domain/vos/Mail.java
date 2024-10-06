package com.personal.usersignup.auth.user.domain.vos;

import com.personal.usersignup.auth.user.domain.errors.MailCannotBeEmpty;
import com.personal.usersignup.auth.user.domain.errors.MailHaveWrongFormat;
import com.personal.usersignup.shared.Result;
import com.personal.usersignup.shared.domain.definition.ValueObject;
import com.personal.usersignup.shared.domain.error.DomainError;

public class Mail extends ValueObject {

    private String value;

    private Mail(String value) {
        this.value = value;
    }

    public static Result<DomainError, Mail> of(String mail) {
        boolean mailWasEmpty = mail.isBlank();
        if (mailWasEmpty) {
            return Result.error(new MailCannotBeEmpty("Mail was empty !!"));
        }
        return Result.error(new MailHaveWrongFormat("Mail have wrong format !!"));
    }
}
