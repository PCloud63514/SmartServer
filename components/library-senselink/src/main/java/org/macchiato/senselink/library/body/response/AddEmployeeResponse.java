package org.macchiato.senselink.library.body.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Getter
public class AddEmployeeResponse {
    private Long id;

    public AddEmployeeResponse(Long id) {
        this.id = id;
    }
}
