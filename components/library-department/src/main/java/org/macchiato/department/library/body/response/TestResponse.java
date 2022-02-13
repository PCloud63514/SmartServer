package org.macchiato.department.library.body.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TestResponse {
    private String message;

    public TestResponse(String message) {
        this.message = message;
    }
}
