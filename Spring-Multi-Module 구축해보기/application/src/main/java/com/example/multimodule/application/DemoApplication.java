package com.example.multimodule.application;

import com.example.multimodule.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
(번역)
@SpringBootApplication 다음을 모두 추가하는 편리한 주석입니다.

@Configuration: 애플리케이션 컨텍스트에 대한 Bean 정의 소스로 클래스에 태그를 지정합니다.

@EnableAutoConfiguration: Spring Boot에 클래스 경로 설정, 기타 Bean 및 다양한 속성 설정에 따라 Bean 추가를 시작하도록 지시합니다. 예를 spring-webmvc들어가 클래스 경로에있는 경우이 주석은 애플리케이션을 웹 애플리케이션으로 플래그 지정하고 DispatcherServlet.

@ComponentScan: Spring에 com/example패키지 에서 다른 구성 요소, 구성 및 서비스를 찾도록 지시 하여 컨트롤러를 찾을 수 있도록합니다.
* */

@SpringBootApplication(scanBasePackages = "com.example.multimodule")
public class DemoApplication {

    private final MyService myService;


    public DemoApplication(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public String name() {
        return myService.message();
    }

    public static void main(String[] args) {
        /*
        (번역)
        이 main()방법은 Spring Boot의 SpringApplication.run()방법을 사용하여 애플리케이션을 시작합니다.
        XML이 한 줄도 없다는 것을 알고 계셨습니까?
        web.xml파일 도 없습니다.
        이 웹 애플리케이션은 100 % 순수 Java이며 배관이나 인프라를 구성 할 필요가 없습니다.
        * */
        SpringApplication.run(DemoApplication.class, args);
    }
}
