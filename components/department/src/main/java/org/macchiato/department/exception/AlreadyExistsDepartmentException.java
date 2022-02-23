package org.macchiato.department.exception;

import org.macchiato.support.exception.AlreadyExistsException;

public class AlreadyExistsDepartmentException extends AlreadyExistsException implements DepartmentCode {
    public AlreadyExistsDepartmentException() {
        super("부서와 동일한 아이디가 이미 존재합니다.");
    }
}
