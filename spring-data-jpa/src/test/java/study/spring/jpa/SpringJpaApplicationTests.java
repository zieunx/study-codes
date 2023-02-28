package study.spring.jpa;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManagerFactory;

@Slf4j
@SpringBootTest
class SpringJpaApplicationTests {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Test
	void contextLoads() {
		log.info("entityManagerFactory={}", entityManagerFactory.getClass());
	}

}
