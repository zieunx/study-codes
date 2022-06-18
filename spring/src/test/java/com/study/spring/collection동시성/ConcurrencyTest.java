package com.study.spring.collection동시성;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.study.spring.collection동시성.service.VendorDefaultServiceImpl;
import com.study.spring.collection동시성.service.OrderService;
import com.study.spring.collection동시성.service.VendorCoupangServiceImpl;
import com.study.spring.collection동시성.service.VendorService;
import com.study.spring.collection동시성.service.VendorTmonServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcurrencyTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
	private OrderService orderService;
	//
	// @BeforeEach
	// public void initTest() {
	// 	Map<String, VendorService> vendorMap = ac.getBeansOfType(VendorService.class);
	// 	List<VendorService> vendorServices = vendorMap.keySet().stream().map(vendorMap::get).collect(Collectors.toList());
	// 	DefaultVendorServiceImpl defaultVendorService = new DefaultVendorServiceImpl();
	//
	// 	orderService = new OrderServiceImpl(vendorServices, defaultVendorService);
	// }
	//
	// @Test
	// public void concurrencyA() {
	// 	log.info("concurrencyA 실행");
	//
	// 	orderService.useTicket("TMON", "TMON01231241237863");
	// 	orderService.useTicket("COUPANG", "COUPANG77123124863");
	// }
	//
	//
	@Configuration
	static class TestConfig {

		@Bean
		public VendorService DefaultVendorServiceImpl() {
			return new VendorDefaultServiceImpl();
		}

		@Bean
		public VendorService VendorCoupangServiceImpl() {
			return new VendorCoupangServiceImpl();
		}

		@Bean
		public VendorService VendorTmonServiceImpl() {
			return new VendorTmonServiceImpl();
		}
	}
}
