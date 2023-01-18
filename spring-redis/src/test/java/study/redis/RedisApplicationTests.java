package study.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class RedisApplicationTests {

	@Autowired
	private RedissonClient redissonClient;

	@Test
	void contextLoads() {
		log.info("redissonClient: {}", redissonClient.getClass());
	}

}
