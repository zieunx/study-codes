package com.study.spring.collection동시성.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final DefaultVendorServiceImpl defaultVendorService;

	private final List<VendorService> salesChannelServices;

	private VendorService vendorService;

	@Override
	public void useTicket(String vendorCode, String ticketNumber) {
		log.info("======> OrderServiceImpl.useTicket() 시작");

		vendorService = findVendorService(vendorCode);

		vendorService.useTheTicket(ticketNumber);

		log.info("======> OrderServiceImpl.useTicket() 끝");
	}

	private VendorService findVendorService(String vendorCode) {
		List<VendorService> vendorServices = salesChannelServices.stream().filter(
			vendorService -> vendorService.getVendorName().equals(vendorCode)
		).collect(Collectors.toList());

		return vendorServices.stream().findFirst().orElse(defaultVendorService);
	}
}
