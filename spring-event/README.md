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

### Spring Event 구독과 발행, 테스트 할 수 있을까?

기본적으로 이벤트 발행은 `ApplicationContext` 내에서 돌기 때문에 @SpringBootTest 어노테이션을 통해 테스트를 진행해야 한다고 생각했다.  
`ApplicationEventPublisher` 의존성을 추가하여 이벤트를 발행할 거다.

**문제는 이벤트를 읽어들이는 쪽은 어떻게 확인할 것인가?**

여러번 고민하다가.. 핸들러(=리스너)는 사실 **어노테이션+이벤트 조합으로 구성되어있으면 무조건 구독한다고 가정하면 된다.**  
그래서 실제 핸들러와 유사한 테스트핸들러 Bean을 만들었고, 해당 Bean이 상태를 가지도록 구현했다.

> <실제 핸들러로 테스트 하지 않은 이유>
> 실제 핸들러가 상태를 가지거나, 테스트를 위해 코드를 작성하는 것을 방지하고 핸들러 원본 코드는 건들지 않으면서 테스트 하는 것이 좋다고 판단했기 때문이다.
> 핸들러와 구성이 같은 테스트 핸들러로 테스트를 한다면 1차적인 테스트는 할 수 있다고 판단했다.

테스트 핸들러는 다음과 같다.

```java

@Component
class TestOrderEventHandler {
    private final AtomicBoolean eventHandled; // 이벤트가 발행되면 상태가 바뀐다.

    public TestOrderEventHandler() {
        this.eventHandled = new AtomicBoolean(false);
    }

    @EventListener
    public void handleOrderEvent(PayloadApplicationEvent<OrderEvent> event) {
        eventHandled.set(true);
    }

    public boolean isSubscript() {
        return eventHandled.get();
    }
}

```

무엇을 테스트 하려는가? 이벤트 발행에 따른 정상적으로 구독이 작동하는지 테스트 하려는 것이다.  
핸들러 내부에 어떤 코드가 있는지, 그 코드가 제대로 작동하는지 테스트 하려는 것이 아니다.  
온전히 **Spring Event**가 발행,구독이 정상적인지 테스트 하려는 것이다!  

최종 테스트 코드는 다음과 같다.

```java
// 이벤트 객체 (Object 타입으로 발행한다. ApplicationEvent 상속받지 않음.)
public class OrderEvent {
    private Long orderId;
    private String userId;

    public OrderEvent(Long orderId, String userId) {
        this.orderId = orderId;
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }
}

```

```java
import com.study.springevent.domain.order.domain.OrderEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class EventPublishTest {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private TestOrderEventHandler orderEventHandler;

    @Test
    public void testSampleEventPublishing() {
        // Given
        OrderEvent event = new OrderEvent(1L, "userId");

        // When
        eventPublisher.publishEvent(event);

        // Then
        assertThat(orderEventHandler.isSubscript()).isTrue();
    }

}

```

깔꼬롬 하다~