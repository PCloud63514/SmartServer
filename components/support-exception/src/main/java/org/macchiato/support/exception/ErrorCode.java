package org.macchiato.support.exception;

public enum ErrorCode {
    NOT_FOUND(1);
    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
