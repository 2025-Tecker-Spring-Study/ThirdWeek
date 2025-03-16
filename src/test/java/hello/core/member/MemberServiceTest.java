package hello.core.member;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given : 해당 데이터가 주고
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when : 데이터가 주어졌을때 이런 행위를 하며
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : 다음과 같은 결과가 나온다.
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
