package study.redis.domain.order.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
@SpringBootTest
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    void 동일한사용자가_따닥했을_때_에러발생() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 같은 orderSheetId 로 동시에 2개 요청
        executorService.execute(() -> {
            orderService.register("orderSheetId-1");
        });

        executorService.execute(() -> {
            orderService.register("orderSheetId-1");
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}