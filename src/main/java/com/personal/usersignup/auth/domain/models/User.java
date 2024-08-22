package com.personal.usersignup.auth.domain.models;

import com.personal.usersignup.auth.domain.records.read.UserDefinition;

public class User {
    private String mail;
    private String username;
    private String password;

    private User(String mail, String username, String password) {
        this.mail = mail;
        this.username = username;
        this.password = password;
    }

    public static User create(String mail, String username, String password) {
        return new User(mail, username, password);
    }


    public UserDefinition toDefinition() {
        return new UserDefinition(this.mail, this.username);
    }
}
