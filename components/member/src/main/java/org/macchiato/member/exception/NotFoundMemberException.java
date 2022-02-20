package org.macchiato.member.exception;

import org.macchiato.support.exception.NotFoundEntityException;

public class NotFoundMemberException extends NotFoundEntityException implements MemberException {
    public NotFoundMemberException() {
        super("사용자가 존재하지 않습니다.");
    }
}
