package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // @Configuration이 붙은 클래스를 제외하고 자동 스캔
        // 즉, AppConfig 설정 파일을 제외하고 빈으로 등록함

)
public class AutoAppConfig {

}
