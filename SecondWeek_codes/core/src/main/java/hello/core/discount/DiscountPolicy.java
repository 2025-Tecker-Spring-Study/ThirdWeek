package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
//
//    @return 할인 금액
//
    int discount(Member member, int price);
}

// 즉, FixDiscountPolicy에서는 고정할인금액을 리턴하고
// RateDiscountPolicy에서는 정가에 비례하는 할인 금액을 리턴한다.
// 즉, discount 메서드는 할인금액을 계산후 반환하는 메서드
