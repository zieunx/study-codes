# Spring Webflux 공부하기

> 공식문서: https://docs.spring.io/spring-framework/reference/web/webflux.html

### 간략하게 주요 특징 훑어보기

- 적은 수의 스레드로 동시성을 처리할 수 있음
- 더 적은 하드웨어 리소스 사용
- 비동기/논블로킹 생태계의 잘 확립된 `Netty`같은 서버들을 고려햐여 새로운 API 필요성
- 함수형 프로그래밍
  -  CompletableFuture 및 ReactiveX와 같은 연속성 기반 API에 이점
- **Reactive**
  - Reactive: 변경에 반응하는 것을 기반으로 하는 프로그래밍 모델
  - Non-blocking은 반응형. 블로킹되지 않고 작업이 완료되거나 데이터가 이용 가능하다는 알림을 받아서 반응하기 때문.
  - 작업이 진행되는 동안 다른 작업을 수행할 수 있고, 더 효율적으로 자원을 활용할 수 있다.
- **Reactive Streams**
  - **back pressure**: 데이터를 처리할 수 있는 속도에 맞춰서 데이터를 생산하는 것
  - Reactive Streams는 back pressure를 지원하는 명세
  - 주요목적: 구독자가 발행자가 데이터를 얼마나 빠르게 또는 느리게 생성하는지를 제어할 수 있도록 하는 것

