package org.macchiato.support.exception;

import org.macchiato.support.exception.core.ErrorCode;
import org.macchiato.support.exception.core.ErrorCodeException;

public abstract class AlreadyExistsException extends IllegalArgumentException implements ErrorCodeException {

    public AlreadyExistsException() {
    }

    public AlreadyExistsException(String s) {
        super(s);
    }

    public AlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyExistsException(Throwable cause) {
        super(cause);
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.ALREADY_EXISTS;
    }
}
