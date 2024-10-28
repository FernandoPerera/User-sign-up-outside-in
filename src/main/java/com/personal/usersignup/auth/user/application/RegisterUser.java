package com.personal.usersignup.auth.user.application;

import com.personal.usersignup.auth.user.domain.models.User;
import com.personal.usersignup.auth.user.domain.records.read.UserDefinition;
import com.personal.usersignup.auth.user.domain.records.write.UserRegistration;
import com.personal.usersignup.auth.user.domain.repositories.UserRepository;
import com.personal.usersignup.auth.user.domain.vos.Mail;
import com.personal.usersignup.auth.user.domain.vos.Username;
import com.personal.usersignup.auth.user.infrastructure.security.FakeAuthenticationTokenHandler;
import com.personal.usersignup.shared.Result;
import com.personal.usersignup.shared.domain.error.DomainError;
import org.springframework.stereotype.Component;

@Component
public class RegisterUser {

    private final UserRepository userRepository;

    public RegisterUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Result<DomainError, UserDefinition> execute(UserRegistration userToRegister) {
        Result<DomainError, Username> usernameResult = Username.of(userToRegister.username());
        Result<DomainError, Mail> mailResult = Mail.of(userToRegister.mail());

        if (mailResult.isError()) {
            return Result.error(mailResult.getError());
        }
        if (usernameResult.isError()) {
            return Result.error(usernameResult.getError());
        }

        User userToSave = User.create(
                mailResult.getResult(),
                usernameResult.getResult(),
                userToRegister.password()
        );
        userRepository.save(userToSave);

        String token = FakeAuthenticationTokenHandler.generateToken();
        return Result.success(new UserDefinition(usernameResult.getResult().getValue(), token));
    }
}
