package service;

import domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import respository.MemberRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberSeviceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public void addMember(Member member) {
        memberRepository.saveMember(member);
    }

    @Override
    public Member getMember(Long memberId) {
        Optional<Member> memberById = memberRepository.findMemberById(memberId);

        return memberById.get();
    }

    @Override
    public List<Member> getMemberlist() {
        List<Member> memberList = memberRepository.findAll();
        return memberList;
    }

    @Override
    public void modifyMember(Member member) {

    }

    @Override
    public void deleteMember(Long memberId) {

    }
}
