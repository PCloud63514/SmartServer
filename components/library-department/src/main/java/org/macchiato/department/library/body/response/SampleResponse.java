package org.macchiato.department.library.body.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class SampleResponse<T> {
    private UUID id;
    private T data;

    public SampleResponse(UUID id, T data) {
        this.id = id;
        this.data = data;
    }
}
