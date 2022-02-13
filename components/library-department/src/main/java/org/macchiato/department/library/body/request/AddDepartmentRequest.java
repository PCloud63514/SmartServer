package org.macchiato.department.library.body.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class AddDepartmentRequest {
    @NotBlank(message = "부서 명이 입력되지 않았습니다.")
    private String name;
    @Nullable
    private String description;
}
