package org.macchiato.senselink.library.body.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class AddEmployeeRequest {
    private final int type;
    private final String name;
    private final String avatarBytes;
    private final int gender;
    private final String birthday;
    private final Long departmentId;

    public AddEmployeeRequest(int type, String name, String avatarBytes, int gender, String birthday, Long departmentId) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 비어있을 수 없습니다.");
        }

        if(birthday != null && !birthday.matches("(19[0-9][0-9]|20\\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])")) {
            throw new IllegalArgumentException("생년월일 형태가 올바르지 않습니다.");
        }

        this.type = type;
        this.name = name;
        this.avatarBytes = avatarBytes;
        this.gender = gender;
        this.birthday = birthday;
        this.departmentId = departmentId;
    }
}
