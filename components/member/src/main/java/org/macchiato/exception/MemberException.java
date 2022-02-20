package org.macchiato.exception;

import org.macchiato.support.exception.DomainCode;

public interface MemberException extends DomainCode {

    @Override
    default int getDomainCode() {
        return 1000;
    }
}