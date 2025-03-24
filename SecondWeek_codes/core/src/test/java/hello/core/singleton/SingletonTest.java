package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
//    SingletonService singletonService = new SingletonService();
//    'SingletonService()' has private access in 'hello.core.singleton.SingletonService'

    @Test
    void pureContainer() {
        // 스프링 컨테이너를 이용하지 않았을 때는 객체가 싱글톤으로  관리되지 않는다.
        AppConfig appConfig = new AppConfig();

        MemberService memberServiceA = appConfig.memberService();
        MemberService memberServiceB = appConfig.memberService();

//        Assertions.assertThat(memberServiceA).isEqualTo(memberServiceB);
        Assertions.assertThat(memberServiceA).isNotEqualTo(memberServiceB);

    }


    @Test
    void singletonService() {
        // 스프링 컨테이너 사용 시 모든 빈이 싱글톤으로 관리된다.
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberServiceA = ac.getBean(MemberService.class);
        MemberService memberServiceB = ac.getBean(MemberService.class);

        Assertions.assertThat(memberServiceA).isEqualTo(memberServiceB);
//        Assertions.assertThat(memberServiceA).isNotEqualTo(memberServiceB);

    }

}
