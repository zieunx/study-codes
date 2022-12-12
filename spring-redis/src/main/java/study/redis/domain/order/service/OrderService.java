package study.redis.domain.order.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class OrderService {

    private final RedissonClient redissonClient;

    public OrderService(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    public void register(String userId) {
        RLock lock = redissonClient.getLock("order:" + userId);

        try {
            boolean isLocked = lock.tryLock(0, 3, TimeUnit.SECONDS);
            log.info("({} 의 락 획득)", userId);
            if (!isLocked) {
                throw new IllegalStateException("락을 획득할 수 없습니다.");
            }

            log.info("주문 등록 처리중 ... ");
        } catch (Exception e) {
            log.error("에러 발생 {}: {}", e.getClass(), e.getMessage());
        } finally {
            log.info("(unlock 수행)");
            lock.unlock();
        }

        log.info("주문 처리 완료");
    }
}
