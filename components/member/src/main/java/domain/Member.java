package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Member {
    private final Long memberId;
    @NonNull
    private final String memberName;
    @NonNull
    private final String mailAddress;
}
