package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Member {
    private final Long memberId;
    @NonNull
    private final String memberName;
    @NonNull
    private final String mailAddress;
}
