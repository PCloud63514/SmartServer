package org.macchiato.support.exception.core;

public enum ErrorCode {
    NOT_EXISTS(1);
    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
