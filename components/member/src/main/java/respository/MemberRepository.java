package respository;

import domain.Member;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public interface MemberRepository {
    void saveMember(Member member);

}
