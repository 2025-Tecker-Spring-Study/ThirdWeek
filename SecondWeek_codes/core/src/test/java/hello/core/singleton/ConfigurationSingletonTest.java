package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void ConfigurationSpringSingletonTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberServiceA = ac.getBean(MemberService.class);
        MemberService memberServiceB = ac.getBean(MemberService.class);

        Assertions.assertThat(memberServiceA).isEqualTo(memberServiceB);
        System.out.println("Class of memberServiceA = " + memberServiceA.getClass());
        System.out.println("memberServiceA = " + memberServiceA);
        System.out.println("memberServiceB = " + memberServiceB);

    }

    @Test
    void AppConfigTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig appConfig = ac.getBean(AppConfig.class);
        System.out.println("AppConfig Object : " + appConfig);
    }


}
