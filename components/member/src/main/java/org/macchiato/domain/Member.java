package org.macchiato.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Member {
    private Long memberId;
    @NonNull
    private String memberName;
    @NonNull
    private String mailAddress;
}
