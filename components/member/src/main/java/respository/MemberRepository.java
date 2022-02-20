package respository;

import domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void saveMember(Member member);

    Optional<Member> findMemberById(Long memberId);

    List<Member> findAll();

    void deleteMember(Long memberId);
}
