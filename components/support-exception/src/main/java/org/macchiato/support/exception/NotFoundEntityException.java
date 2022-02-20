package org.macchiato.support.exception;

/**
 * 이런 공용적인 요소는 1~999
 */

/**
 * user and department 1000
 *
 * Not found - 1
 * User - 1000
 * 1001
 */
public abstract class NotFoundEntityException extends IllegalStateException implements ExceptionCode {
    public NotFoundEntityException(String s) {
        super(s);
    }

    @Override
    public int getExceptionCode() {
        return 1;
    }
}
