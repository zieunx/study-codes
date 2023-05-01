package com.study.springevent.event;

import com.study.springevent.domain.order.domain.OrderEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class TestEventHandler {
    private final ConcurrentLinkedQueue<Object> eventHandled;

    public TestEventHandler() {
        this.eventHandled = new ConcurrentLinkedQueue<>();
    }

    @EventListener
    public void handleOrderEvent(PayloadApplicationEvent<OrderEvent> event) {
        eventHandled.add(event);
    }

    public boolean isSubscript(Class<?> eventClass) {
        return eventHandled.stream()
                .anyMatch(event ->
                        ((PayloadApplicationEvent<?>) event).getPayload().getClass() == eventClass
                );
    }

    public void clear() {
        eventHandled.clear();
    }
}
