package service;

import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import respository.MemberRepository;

import java.util.List;

public class MemberSeviceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public void addMember(Member member) {
        memberRepository.saveMember(member);
    }

    @Override
    public Member getMember(Long memberId) {
        return null;
    }

    @Override
    public List<Member> getMemberlist() {
        return null;
    }


}
