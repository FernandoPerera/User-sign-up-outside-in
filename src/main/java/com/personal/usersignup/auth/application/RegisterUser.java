package com.personal.usersignup.auth.application;

import com.personal.usersignup.auth.domain.models.User;
import com.personal.usersignup.auth.domain.records.read.UserDefinition;
import com.personal.usersignup.auth.domain.records.write.UserRegistration;
import com.personal.usersignup.auth.domain.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class RegisterUser {

    private final UserRepository userRepository;

    public RegisterUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDefinition execute(UserRegistration userToRegister) {
        User userToSave = User.create(
                userToRegister.mail(),
                userToRegister.username(),
                userToRegister.password()
        );

        User registeredUser = userRepository.save(userToSave);

        return registeredUser.toDefinition();
    }
}
