package com.personal.usersignup.auth.user.application;

import com.personal.usersignup.auth.user.domain.models.User;
import com.personal.usersignup.auth.user.domain.records.read.UserDefinition;
import com.personal.usersignup.auth.user.domain.records.write.UserRegistration;
import com.personal.usersignup.auth.user.domain.repositories.UserRepository;
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
