package hello.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscountService {

    @Bean
    @Qualifier("rateDiscount")
    public DiscountPolicy rateDiscount() {
        return new RateDiscountPolicy();
    }

    @Bean
    @Qualifier("fixDiscount")
    public DiscountPolicy fixDiscount() {
        return new FixDiscountPolicy();
    }


}
