package com.study.spring.collection동시성.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VendorTmonServiceImpl implements VendorService {
	@Override
	public void useTheTicket(String ticketNumber) {
		log.info("티몬 useTheTicket() 호출");

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getVendorName() {
		return VendorConsts.TMON_CODE;
	}
}
