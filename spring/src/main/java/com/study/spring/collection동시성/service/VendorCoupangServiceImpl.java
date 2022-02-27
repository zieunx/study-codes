package com.study.spring.collection동시성.service;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VendorCoupangServiceImpl implements VendorService {
	@Override
	public void useTheTicket(String ticketNumber) {
		log.info("쿠팡 useTheTicket() 호출");
	}

	@Override
	public String getVendorName() {
		return VendorConsts.COUPANG_CODE;
	}
}
