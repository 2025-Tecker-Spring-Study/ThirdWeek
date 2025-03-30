package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.DiscountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiscountPolicyTest {

    @Test
    void TwoDiscountPolicyBeanTest() {
        AnnotationConfigApplicationContext discountConfig = new AnnotationConfigApplicationContext(DiscountService.class);

        DiscountPolicy rateDiscount = discountConfig.getBean("rateDiscount", DiscountPolicy.class);
        DiscountPolicy fixDiscount = discountConfig.getBean("fixDiscount", DiscountPolicy.class);

        System.out.println("rateDiscount : " + rateDiscount);
        System.out.println("fixDiscount : " + fixDiscount);

    }
}
