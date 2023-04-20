# Sping Multi Module 구축해보기



참고 :

* [spring 공식 문서 - creating a Multi Module Project](https://spring.io/guides/gs/multi-module/)
* [스프링 부트로 멀티모듈 셋팅하기](https://taetaetae.github.io/2020/01/19/spring-boot-maven-multi-module/)
* [멀티모듈 설계 이야기 with Spring, Gradle](https://woowabros.github.io/study/2019/07/01/multi-module.html)
* [Gradle 멀티 프로젝트 관리](https://jojoldu.tistory.com/123)


---

## Annotation 과 Annotation Processor

`@interface`: 컴파일러가 사용자 정의 어노테이션이라고 인지한다.

`@Retention`
- SOURCE: 컴파일러에 의해 분석됨
- CLASS: 클래스파일에 저장됨, 런타임엔 유지되지 않음
- RUNTIME: 클래스파일에 저장됨, 리플랙션에 의해 런타임에 사용 가능

`AbstractProcessor` class
- 