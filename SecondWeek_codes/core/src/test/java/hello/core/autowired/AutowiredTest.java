package hello.core.autowired;

import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {

    @Test
    void setNoBeans() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    }


    static class NoBeanTest {

        @Autowired(required = false)
        void setNoBean1 (Member noBean1){
        System.out.println("bean1 : " + noBean1);
    }


        void setNoBean2 (@Nullable Member noBean2){
        System.out.println("bean2 : " + noBean2);
    }

    }
}
