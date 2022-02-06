package respository;

import domain.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        }
    }

    @Override
    public Optional<Member> findMemberById(Long memberId) {
        return this.memberList.stream().filter(mem -> mem.getMemberId() == memberId).collect(Collectors.toList()).stream().findFirst();
    }

    @Override
    public List<Member> findAll() {
        return memberList;
    }
    @Override
    public void deleteMember(Long memberId) {
        Optional<Member> member = this.memberList.stream().filter(mem -> mem.getMemberId() == memberId).collect(Collectors.toList()).stream().findFirst();
        if (!member.isEmpty()) {
            memberList.remove(member);
        }
    }
}
