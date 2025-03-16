package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	// 서버 실행 메소드
	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
	// String[] args는 커맨드 라인 인자 Command Line Arguments
	// 애플리케이션 실행 시 커맨드 라인에서 데이터를 전달받아 중괄호 내부 내용을 실행한다.

	// SpringApplication.run( ... ) : Spring Boot 애플리케이션을 실행한다.
	// 해당 메소드는 애플리케이션의 설정을 읽은 후 Spring Context를 초기화한 뒤 실행한다.
}

// Q. Spring Context?
// 애플리케이션의 설정 정보를 담는 컨테이너
// 즉, 애플리케이션의 객체(Bean)와 의존성 주입 설정을 관리한다.

// Q. 개발에서 Context란 뭘까?
// A. 애플리케이션에서 사용되는 설정, 환경, 상태 등을 포함한 정보를 말한다.
