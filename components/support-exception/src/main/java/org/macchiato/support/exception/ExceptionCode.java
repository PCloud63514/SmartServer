package org.macchiato.support.exception;


public interface ExceptionCode extends DomainCode {
    int getExceptionCode();

    default int code() {
        return getExceptionCode() + getDomainCode();
    }
}
