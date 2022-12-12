package study.redis.domain.order.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@SpringBootTest
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    void 동일한사용자가_따닥했을_때_에러발생() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch (2);
        executorService.execute(() -> {
            orderService.register("사용자ID-1");
        });
        executorService.execute(() -> {
            orderService.register("사용자ID-1");
        });
    }
}