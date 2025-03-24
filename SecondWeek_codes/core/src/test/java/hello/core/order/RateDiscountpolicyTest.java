package hello.core.order;

import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountpolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

//    public Member(Long id, String name, Grade grade)

//    테스트코드 작성 로직
//    1. @Test 애노테이션이 달린 테스트용 메서드는 반환값이 없다.
//    즉, void로 선언하여 작성
//    2. 테스트용 객체를 생성
//    3. Assertions를 통해 테스트 결과가 옳은지 확인, 추가로 isEqualTo같은 메서드와 함께 사용


    @Test
    public void vip() {
        Member memberA = new Member(1L, "daiseek", Grade.VIP);

        int discount = rateDiscountPolicy.discount(memberA, 20000);

        Assertions.assertThat(discount);
        System.out.println("memberA discount :" + discount);
        Assertions.assertThat(discount).isEqualTo(2000);
    }

    @Test
    public void notVip() {
        Member memberB = new Member(2L, "jaiseek", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(memberB, 20000);

        Assertions.assertThat(discount).isEqualTo(0);
    }


}
