package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{
    int discountRate = 10;

    @Override
    // 할인이후 금액을 내뱉음
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return  price * discountRate/100;
        } else {
            return 0;
        }
    }
}
