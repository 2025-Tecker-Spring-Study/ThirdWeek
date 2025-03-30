package hello.core;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.*;

import java.lang.annotation.*;

@Component
@Controller
@Service
@Repository
@Configuration
public class WhatIsAnnotation {
    // this is just a class to study annotations for spring.

    // 위 애노테이션들 모두 컴포넌트 스캔 시 사용한다.
    // 각각 @Component가 내장되어 있어 자동으로 스캔되는데 코드에서 어떤 차이가 있을까?


}
