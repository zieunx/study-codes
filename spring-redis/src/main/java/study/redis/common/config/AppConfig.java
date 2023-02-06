package study.redis.common.config;

import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.redis.domain.order.service.OrderService;
import study.redis.domain.order.service.OrderServiceV1;

@Configuration
public class AppConfig {

    private final RedissonClient redissonClient;

    public AppConfig(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceV1(redissonClient);
    }

}
