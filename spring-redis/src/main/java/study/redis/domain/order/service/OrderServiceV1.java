package study.redis.domain.order.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class OrderServiceV1 implements OrderService {

    private final RedissonClient redissonClient;

    public OrderServiceV1(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    public String register(String userId) {
        RLock lock = redissonClient.getLock("orderTemp:" + userId);
        boolean isLocked = false;
        try {
            isLocked = lock.tryLock(0, 3, TimeUnit.SECONDS);

            if (!isLocked) {
                throw new IllegalStateException("락을 획득할 수 없습니다.");
            }

            /* 비즈니스 로직 */
            log.info("주문 등록 처리중 ... ");
            log.info("주문 처리 완료");
            return "주문 완료";
        } catch (IllegalStateException | InterruptedException e) {
            log.error("에러 발생 {}", e.getMessage(), e);
        } finally {
            if (isLocked) {
                log.info("(unlock 수행)");
                lock.unlock();
            }
        }
        return "주문 실패";
    }
}
