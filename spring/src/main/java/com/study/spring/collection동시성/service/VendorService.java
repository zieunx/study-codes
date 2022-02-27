package com.study.spring.collection동시성.service;

import org.springframework.stereotype.Service;

@Service
public interface VendorService {

	public void useTheTicket(String ticketNumber);

	public String getVendorName();
}
