package org.macchiato.respository;

import org.macchiato.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Long saveMember(Member member);

    Optional<Member> findMemberById(Long memberId);

    List<Member> findAll();

    void deleteMember(Long memberId);
}