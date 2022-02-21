package org.macchiato.support.exception;

public abstract class NotFoundEntityException extends IllegalStateException implements ErrorCodeException {
    public NotFoundEntityException(String s) {
        super(s);
    }

    public NotFoundEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundEntityException(Throwable cause) {
        super(cause);
    }

    public NotFoundEntityException() {
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.NOT_FOUND;
    }
}
