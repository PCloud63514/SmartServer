package org.macchiato.respository;

import org.macchiato.domain.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class MemberDatabaseRepository implements MemberRepository {
    List<Member> memberList = new ArrayList<>();
    private Long index = 1L;
    @Override
    public Long saveMember(Member member) {
        findMemberById(member.getMemberId()).ifPresentOrElse(entity -> {
            entity.setMemberName(member.getMemberName());
            entity.setMailAddress(member.getMailAddress());
        }, ()-> {
            member.setMemberId(index++);
            memberList.add(member);
        });
        return member.getMemberId();
    }

    @Override
    public Optional<Member> findMemberById(Long memberId) {
        return this.memberList.stream().filter(mem -> Objects.equals(mem.getMemberId(), memberId)).findFirst();
    }

    @Override
    public List<Member> findAll() {
        return memberList;
    }

    @Override
    public void deleteMember(Long memberId) {
        findMemberById(memberId).ifPresent(value -> memberList.remove(value));
    }
}