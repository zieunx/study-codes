package com.study.spring.collection동시성.service;

import org.springframework.stereotype.Service;

public interface OrderService {
	public void useTicket(String vendorCode, String ticketNumber);
}
