package hello.core.singleton;

import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatefulServiceTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    void StatefulServiceTest() {

        StatefulService statefulServiceA = ac.getBean(StatefulService.class);
        StatefulService statefulServiceB = ac.getBean(StatefulService.class);

        statefulServiceA.order("CarA", 100);
        statefulServiceB.order("CarB", 10000);

        String userAItem = statefulServiceA.getItemName();
        String userBItem = statefulServiceB.getItemName();

        Assertions.assertThat(userAItem).isEqualTo("CarA");
//        Expected :"CarA"
//        Actual   :"CarB"
//        <Click to see difference>


    }

}


    @Configuration
    class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        };
    }
