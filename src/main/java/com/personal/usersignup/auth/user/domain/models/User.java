package com.personal.usersignup.auth.user.domain.models;

import com.personal.usersignup.auth.user.domain.records.read.UserDefinition;
import com.personal.usersignup.auth.user.domain.vos.Mail;
import com.personal.usersignup.auth.user.domain.vos.Username;

public class User {
    private Mail mail;
    private Username username;
    private String password;

    private User(Mail mail, Username username, String password) {
        this.mail = mail;
        this.username = username;
        this.password = password;
    }

    public static User create(Mail mail, Username username, String password) {
        return new User(mail, username, password);
    }

}
