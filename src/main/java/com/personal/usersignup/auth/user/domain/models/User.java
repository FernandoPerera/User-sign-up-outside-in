package com.personal.usersignup.auth.user.domain.models;

import com.personal.usersignup.auth.user.domain.records.read.UserDefinition;
import com.personal.usersignup.auth.user.domain.vos.Mail;

public class User {
    private Mail mail;
    private String username;
    private String password;

    private User(Mail mail, String username, String password) {
        this.mail = mail;
        this.username = username;
        this.password = password;
    }

    public static User create(Mail mail, String username, String password) {
        return new User(mail, username, password);
    }

    public UserDefinition toDefinition(String token) {
        return new UserDefinition(this.username, token);
    }
}
