package org.macchiato.senselink.library.body.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Getter
public class SenseLinkResponse<T> {
    private int code;
    private T data;
    private String message;
    private String subCode;

    public SenseLinkResponse(int code, String message, String subCode, T data) {
        this.code = code;
        this.message = message;
        this.subCode = subCode;
        this.data = data;
    }
}
