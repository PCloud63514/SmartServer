package org.macchiato.department.exception;

import org.macchiato.support.exception.NotExistsException;

public class NotExistsDepartmentException extends NotExistsException implements DepartmentCode {
    public NotExistsDepartmentException() {
        super("해당 부서가 존재하지 않습니다.");
    }
}
