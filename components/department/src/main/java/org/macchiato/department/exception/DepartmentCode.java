package org.macchiato.department.exception;

import org.macchiato.support.exception.core.DomainCode;

public interface DepartmentCode extends DomainCode {
    @Override
    default int getDomainCode() {
        return 2000;
    }
}
