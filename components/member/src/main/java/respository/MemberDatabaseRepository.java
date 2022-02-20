package respository;

import domain.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class MemberDatabaseRepository implements MemberRepository{
    List<Member> memberList = new ArrayList<>();

    @Override
    public void saveMember(Member member) {
        Optional<Member> memberById = findMemberById(member.getMemberId());

        if (memberById.isEmpty()) {
            memberList.add(member);
        }else {
            Member member1 = memberById.get();
            member1.setMemberName(member.getMemberName());
            member1.setMailAddress(member.getMailAddress());
        }
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
