package org.macchiato.department.exception;

import org.macchiato.support.exception.DomainCode;

public interface DepartmentException extends DomainCode {
    @Override
    default int getDomainCode() {
        return 2000;
    }
}
