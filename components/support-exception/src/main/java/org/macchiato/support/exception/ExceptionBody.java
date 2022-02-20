package org.macchiato.support.exception;

import lombok.Getter;

@Getter
public class ExceptionBody {
    private final int code;
    private final String message;

    public ExceptionBody(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
