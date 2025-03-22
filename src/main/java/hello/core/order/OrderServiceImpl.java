package hello.core.order;

import hello.core.discount.DiscountPolicy;
//import hello.core.discount.FixDiscountPolicy;
//import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
//import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 인터페이스의 구현 클래스를 이용해 구현체를 만듦
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // => OCP, DIP 위반

    // 따라서 기존 코드를 지우고, AppConfig 파일을 이용해 구현체를 주입하자!
    private final MemberRepository memberRepository;


    // 인터페이스에만 의존하도록 변경
//    private DiscountPolicy discountPolicy;
    // but Test 코드 가동시 NullPointerException 발생
    // DiscountPolicy 인터페이스에는 아무 구현체가 할당되지 않았기 때문이다!

    // 따라서 기존 코드를 지우고, AppConfig 파일을 이용하자!

    private final DiscountPolicy discountPolicy;

    // 생성자 주입을 통해 구현체를 할당해준다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 구현체에 의존하고 있나? => No!
    // 구현체의 세부 내용을 몰라도 코드를 실행할 수 있다!!

    // 어느 Repository에서 가져오든지 신경안씀
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // 단일 책임 원칙을 지킨 메소드
        // 할인을 적용하는 메소드의 내부 기능은 모르지만, 매개값을 던져주면 할인 적용 기능을 한다.
        int discountPrice =  discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    // 테스트용 코드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
