# Spring Webflux 공부하기

> 공식문서: https://docs.spring.io/spring-framework/reference/web/webflux.html

## 주요 특징 훑어보기

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

### Reactive API
- webflux의 Reacive library는 `Reactor`
- [Mono](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html): 0~1
- [Flux](https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html): 0~N
- 다른 Reacive library에서 생성된 스트림도 입력으로 받을 수 있음
- webflux는 다른 Reacive library와도 잘 작동함
- 다른 라이브러리와도 잘 상호작용하도록 설계되어있지만 반환값은 변환 작업이 필요함
- WebFlux는 코틀린의 코루틴 API와 함께 사용하여 명령형 프로그래밍 스타일을 지원

### 성능
- 성능이 NIO, Reactive 를 쓴다고 좋아지는 건 아님. 오히려 더 느려질 수도 있음. NIO 기술 자체가 복잡하기 때문에.
- 장점은 메모리를 덜 쓸 수 있다는 것과 스레드 수를 줄여준다는 것.
- 실행 속도보다는 효율적으로 시스템을 사용한다는 말이 더 어울린다.
  - 대부분의 시스템에서 병목 현상은 일반적으로 데이터베이스 액세스나 네트워크 I/O와 같은 블로킹 작업에서 발생하기 때문

> 그치만 단일 작업을 비교했을 땐 그럴수 있다고 봄. 트래픽이 많아지면 이점을 가져다주는 상황이 많을거라고 봄.