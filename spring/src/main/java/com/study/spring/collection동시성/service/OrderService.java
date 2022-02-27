package com.study.spring.collection동시성.service;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {
	void useTicket(String vendorCode, String ticketNumber);
}
