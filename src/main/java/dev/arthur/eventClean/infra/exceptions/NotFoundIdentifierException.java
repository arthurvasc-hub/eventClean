package dev.arthur.eventClean.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundIdentifierException extends RuntimeException {

    public NotFoundIdentifierException(String message) {
        super(message);
    }
}
