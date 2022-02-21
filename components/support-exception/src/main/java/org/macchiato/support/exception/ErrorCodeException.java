package org.macchiato.support.exception;


public interface ErrorCodeException extends DomainCode {
    ErrorCode getErrorCode();

    default int code() {
        return getErrorCode().getCode() + getDomainCode();
    }
}
