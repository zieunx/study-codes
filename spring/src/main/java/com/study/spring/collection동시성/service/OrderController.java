package com.study.spring.collection동시성.service;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("order")
@RestController
public class OrderController {

	private final OrderService orderService;

	@PutMapping("use")
	public ResponseEntity<?> useTicket(@RequestParam String vendorCode, @RequestParam String ticketNumber) {

		log.info("Controller 실행 / 요청데이터 [vendorCode={}, ticketNumber={}]", vendorCode, ticketNumber);

		orderService.useTicket(vendorCode, ticketNumber);

		log.info("Controller 종료");

		URI selfLink = URI.create(ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString());
		return ResponseEntity.created(selfLink).build();
	}
}
