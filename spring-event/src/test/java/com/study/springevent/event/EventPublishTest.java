package com.study.springevent.event;

import com.study.springevent.domain.order.domain.OrderEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
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
    private ApplicationContext context;

    @Autowired
    private TestOrderEventHandler orderEventHandler;

    @Test
    public void testSampleEventPublishing() {
        // Given
        OrderEvent event = new OrderEvent(1L, "userId");

        // When
        context.publishEvent(new PayloadApplicationEvent<>(this, event));

        // Then
        assertThat(orderEventHandler.isSubscript()).isTrue();
    }

}

@Component
class TestOrderEventHandler {
    private final AtomicBoolean eventHandled;

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
