package com.test.java.javatest.폭풍if개선하기;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
	private int orderId;
	private String smsYn;
	private String orderStatus;
	private String orderTypeCode;
	private String reserveTimestamp;

	public boolean isDelivery() {
		return ORDER_TYPE.findByCode(this.orderTypeCode).isDelivery();
	}
}
