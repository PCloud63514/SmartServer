package org.macchiato.service;

import org.macchiato.domain.Member;

import java.util.List;

public interface MemberService {
    // 멤버 추가
    Long addMember(Member member);

    // 멤버 조회
    Member getMember(Long memberId);

    // 멤버 복수 조회


    // 멤버 목록 전체 조회
    List<Member> getMembers();

    // 멤버 수정
    void modifyMember(Member member);

    // 멤버 삭제
    void deleteMember(Long memberId);
}
