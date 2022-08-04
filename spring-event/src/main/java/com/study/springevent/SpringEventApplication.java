package com.study.springevent;

import com.study.springevent.cart.domain.Cart;
import com.study.springevent.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEventApplication implements CommandLineRunner {
	private static Logger LOG = LoggerFactory.getLogger(SpringEventApplication.class);
	private final OrderService orderService;

	public SpringEventApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(SpringEventApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception {
		orderService.registerOrder(new Cart("이지은"));
	}
}
