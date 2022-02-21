package org.macchiato.support.exception;

import org.macchiato.support.exception.core.ErrorCode;
import org.macchiato.support.exception.core.ErrorCodeException;

public abstract class NotExistsException extends IllegalStateException implements ErrorCodeException {
    public NotExistsException(String s) {
        super(s);
    }

    public NotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotExistsException(Throwable cause) {
        super(cause);
    }

    public NotExistsException() {
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.NOT_EXISTS;
    }
}
