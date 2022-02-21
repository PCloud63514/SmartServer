package org.macchiato.support.exception.core;


public interface ErrorCodeException extends DomainCode {
    ErrorCode getErrorCode();

    default int code() {
        return getErrorCode().getCode() + getDomainCode();
    }
}
