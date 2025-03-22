package hello.core.member;
// Note. 구현체가 하나뿐일때 관례상 인터페이스이름+Impl을 이용한다.

public class MemberServiceImpl implements MemberService {
// 현 코드의 문제점 : 인터페이스 뿐만 아니라 구현체(MemoryMemberRepository)까지 의존한다.
// DIP 위반

    // 구현 객체가 없으면 join, findMember 메소드 실행시 NullPointerError 속출
    // 따라서 앞서 구현한 MemoryMemberRepository 객체를 생성하여 넣어준다.
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    // 다형성 성질 이용
    // MemberService 인터페이스에서 정의된 메소드를 오버라이딩

    // MemoryMemberRepository를 이용해
    // join, save 메소드 호출 시 오버라이딩한 메소드가 호출되며 실행됨
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

// Q. 위 코드가 DIP, OCP를 위반한 이유?
// A. 10줄에서 MemberRepository에 Memory~ 객체를 자동 타입 변환을 통해 대입함.
// -> MemberRepository 객체에는 실제로 Memory~ 객체가 대입된 것

// 따라서 Memory ~ 클래스가 부모 클래스처럼 작동하고 있다.
// 여기서 메소드를 재정의하여 행위를 실행하고 있는데, 추후에 DB가 설정되면 변경해야 할 가능성이 있다.