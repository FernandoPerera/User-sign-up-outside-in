package com.personal.usersignup.shared.infrastructure.error;

import com.personal.usersignup.shared.domain.error.DomainError;
import org.springframework.http.HttpStatus;

public abstract class HttpErrorMapper {

    protected abstract HttpStatus resolveSpecificError(DomainError error);

    public HttpStatus resolve(DomainError error) {
        boolean isUnknownError = error == null;
        if (isUnknownError) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return resolveSpecificError(error);
    }
}
