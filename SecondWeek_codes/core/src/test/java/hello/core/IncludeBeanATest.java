package hello.core;

import hello.core.member.Member;
import hello.core.scan.filter.BeanA;
import hello.core.scan.filter.MyIncludeComponent;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

public class IncludeBeanATest {
    AnnotationConfigApplicationContext autoAppConfig = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

    @Test
    void includeBeanATest() {
        BeanA beanA = autoAppConfig.getBean(BeanA.class);
        System.out.println("Is BeanA uploaded as a bean? " + beanA);
    }



    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class)
    )
    static class ComponentFilterAppConfig {
        // ...
    }

}
