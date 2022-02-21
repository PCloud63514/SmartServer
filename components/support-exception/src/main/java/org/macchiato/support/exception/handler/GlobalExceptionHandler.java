package org.macchiato.support.exception.handler;

import org.macchiato.support.exception.core.ExceptionBody;
import org.macchiato.support.exception.NotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = { "org.macchiato"})
public class GlobalExceptionHandler {

    @ExceptionHandler(NotExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleNotFoundException(NotExistsException e) {
        return new ExceptionBody(e.code(), e.getMessage());
    }
}
