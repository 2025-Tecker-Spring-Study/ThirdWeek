package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    // 실무에서는 동시성 이슈가 있어서 concurrent HashMap을 사용한다.
    // 회원 데이터를 저장하는 Map 객체
    private static Map<Long, Member> store = new HashMap<>();

    // 회원 가입 메소드
    // 여기서 Map 객체에서 put()메소드가 정의되었기 때문에 사용했다.
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
