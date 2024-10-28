package com.personal.usersignup.auth.user.domain.vos;

import com.personal.usersignup.auth.user.domain.errors.MailCannotBeEmpty;
import com.personal.usersignup.auth.user.domain.errors.MailHaveWrongFormat;
import com.personal.usersignup.shared.Result;
import com.personal.usersignup.shared.domain.definition.ValueObject;
import com.personal.usersignup.shared.domain.error.DomainError;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail extends ValueObject {

    private final String value;

    private static final String regex = "[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,}";

    private Mail(String value) {
        this.value = value;
    }

    public static Result<DomainError, Mail> of(String mail) {
        boolean mailWasEmpty = mail.isBlank();
        if (mailWasEmpty) {
            return Result.error(new MailCannotBeEmpty("Mail was empty !!"));
        }

        boolean isWrongFormat = haveWrongFormat(mail);
        if (isWrongFormat) {
            return Result.error(new MailHaveWrongFormat("Invalid mail format !!"));
        }
        return Result.success(new Mail(mail));
    }

    private static boolean haveWrongFormat(String mail) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);
        return !matcher.matches();
    }

    public String getValue() {
        return value;
    }

}
