package org.macchiato.department.exception;

import org.macchiato.support.exception.NotFoundEntityException;

public class NotFoundDepartmentException extends NotFoundEntityException implements DepartmentException {
    public NotFoundDepartmentException() {
        super("해당 부서가 존재하지 않습니다.");
    }
}
