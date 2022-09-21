# Spring Event

### '주문처리' 과 '장바구니삭제' 강결합 해결해보기
- ApplicationEvent 로 이벤트 발행 및 구독
  - ApplicationEventPublisher 이벤트 발행 : [코드](src/main/java/com/study/springevent/order/service/OrderService.java)
  - 구독(listen)
    1. ApplicationListener 를 구현, onApplicationEvent 를 오버라이딩 하여 이벤트 구독 : [코드](src/main/java/com/study/springevent/cart/domain/DeleteCartWithOrderEventListener.java)
    2. `@EventListener` 어노테이션으로 이벤트 구독 : [코드](src/main/java/com/study/springevent/cart/domain/DeleteCartWithOrderEventHandler.java)
      - @EventListener 는 이벤트가 발행된 직후 이벤트가 실행된다. (트랜잭션 문제 가능성 있음.)
      - 트랜잭션과 무관하게 실행해도 되는 이벤트라면 적절할 수 있다. (이벤트 발행 후 트랜잭션이 rollback되는 상황까지 고려해야함.)
      - `@TransactionalEventListener` 어노테이션을 활용하면 발행 트랜잭션이 commit 된 이후에 실행된다.
- 참고
  - backtony 님의 [Spring - Event Driven](https://velog.io/@backtony/Spring-Event-Driven)
  - cheese10yun 님의 [ApplicationEventPublisher 기반으로 강결합 및 트랜잭션 문제 해결](https://cheese10yun.github.io/event-transaction/)
