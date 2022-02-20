package org.macchiato.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long memberId;
    @NonNull
    private String memberName;
    @NonNull
    private String mailAddress;

    public Member(Long memberId, @NonNull String memberName, @NonNull String mailAddress) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.mailAddress = mailAddress;
    }

    public Member(@NonNull String memberName, @NonNull String mailAddress) {
        this.memberId = -1L;
        this.memberName = memberName;
        this.mailAddress = mailAddress;
    }
}
