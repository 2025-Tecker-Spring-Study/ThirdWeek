package hello.core.scan.filter;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyIncludeComponent {
}
