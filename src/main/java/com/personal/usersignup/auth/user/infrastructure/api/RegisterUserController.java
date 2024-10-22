package com.personal.usersignup.auth.user.infrastructure.api;

import com.personal.usersignup.auth.user.application.RegisterUser;
import com.personal.usersignup.auth.user.domain.records.read.UserDefinition;
import com.personal.usersignup.auth.user.domain.records.write.UserRegistration;
import com.personal.usersignup.auth.user.infrastructure.errors.UserHttpErrorMapper;
import com.personal.usersignup.shared.Result;
import com.personal.usersignup.shared.domain.error.DomainError;
import com.personal.usersignup.shared.infrastructure.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegisterUserController {

    private final RegisterUser registerUser;
    private static final UserHttpErrorMapper USER_HTTP_ERROR_MAPPER = new UserHttpErrorMapper();

    public RegisterUserController(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @PostMapping("/sign_up")
    public ResponseEntity<?> signUp(@RequestBody UserRegistration userToRegister) {
        Result<DomainError, UserDefinition> result = registerUser.execute(userToRegister);

        if (result.isError()) {
            return new ResponseEntity<>(
                    new ErrorResponse(result.getError().getErrorMessage()),
                    USER_HTTP_ERROR_MAPPER.resolve(result.getError())
            );
        }
        return new ResponseEntity<>(result.getResult(), HttpStatus.CREATED);
    }
}
