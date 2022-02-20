package org.macchiato.member.library.body.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class AddMemberRequest {
    @NotBlank(message = "사용자의 이름이 입력되지 않았습니다.")
    private String name;
    @Email
    private String mailAddress;
}