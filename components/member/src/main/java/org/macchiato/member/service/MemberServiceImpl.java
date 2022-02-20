package org.macchiato.member.service;

import org.macchiato.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.macchiato.member.exception.NotFoundMemberException;
import org.springframework.stereotype.Service;
import org.macchiato.member.respository.MemberRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Long addMember(Member member) {
        memberRepository.findMemberById(member.getMemberId()).ifPresentOrElse(entity -> {
            throw new IllegalStateException("이미 존재하는 사용자입니다.");
        }, () -> {
            memberRepository.saveMember(member);
        });
        return member.getMemberId();
    }

    @Override
    public Member getMember(Long memberId) {
        return memberRepository.findMemberById(memberId).orElseThrow(NotFoundMemberException::new);
    }

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void modifyMember(Member member) {
        memberRepository.findMemberById(member.getMemberId()).ifPresentOrElse(entity -> {
            memberRepository.saveMember(member);
        }, () -> {
            throw new NotFoundMemberException();
        });
    }

    @Override
    public void deleteMember(Long memberId) {
        memberRepository.findMemberById(memberId).ifPresentOrElse(entity -> {
            memberRepository.deleteMember(memberId);
        }, () -> {
            throw new NotFoundMemberException();
        });
    }
}
