package com.test.java.javatest.폭풍if개선하기;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

	private ORDER_MESSAGE_SEND_TYPE getOrderMessageSendType(OrderDto orderInfo) {
		ORDER_MESSAGE_SEND_TYPE orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.NONE;
		boolean isDelivery = orderInfo.isDelivery();
		boolean isReservedOrder = Optional.ofNullable(orderInfo.getReserveTimestamp()).isPresent();
		String orderStatus = orderInfo.getOrderStatus();

		if (StringUtils.equals(orderStatus, "70") || StringUtils.equals(orderStatus, "80")) {
			// 취소
			orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.ORDER_CANCELED;
			return orderMessageSendType;
		}

		if (StringUtils.equals(orderInfo.getSmsYn(), "Y")) {
			// 주문 알림톡 수신 동의여부 확인
			if (isDelivery) {
				// 배달주문
				if (StringUtils.equals(orderInfo.getOrderStatus(), "10")) {
					// 접수
					if (isReservedOrder) {
						// 예약주문
						orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.ORDER_DELIVERY_RESERVED;
					} else {
						// 일반주문
						orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.ORDER_DELIVERY_REQUEST;
					}
				} else if (StringUtils.equals(orderStatus, "60")) {
					// 배달완료
					orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.ORDER_DELIVERY_COMPLETED;
				}
			} else {
				// 포장주문
				if (StringUtils.equals(orderInfo.getOrderStatus(), "10")) {
					if (isReservedOrder) {
						// 예약주문
						orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.ORDER_PICKUP_RESERVED;
					} else {
						// 일반주문
						orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.ORDER_PICKUP_REQUEST;
					}
				}
			}
		} else {
			log.info("알림톡 미수신 주문건: [{}]", orderInfo.getOrderId());
		}
		return orderMessageSendType;
	}

	private ORDER_MESSAGE_SEND_TYPE refactoring(OrderDto orderInfo) {
		ORDER_MESSAGE_SEND_TYPE orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.NONE;
		boolean isDelivery = orderInfo.isDelivery();
		boolean isReservedOrder = Optional.ofNullable(orderInfo.getReserveTimestamp()).isPresent();
		String orderStatus = orderInfo.getOrderStatus();

		if (StringUtils.equals(orderStatus, "70") || StringUtils.equals(orderStatus, "80")) {
			// 취소
			orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.ORDER_CANCELED;
			return orderMessageSendType;
		}

		// [리팩토링-1] if문 early return 하기
		if (StringUtils.equals(orderInfo.getSmsYn(), "Y")) {
			log.info("알림톡 미수신 주문건: [{}]", orderInfo.getOrderId());
			return orderMessageSendType;
		}
		// 주문 알림톡 수신 동의여부 확인
		if (isDelivery) {
			// 배달주문
			if (StringUtils.equals(orderInfo.getOrderStatus(), "10")) {
				// 접수
				if (isReservedOrder) {
					// 예약주문
					orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.ORDER_DELIVERY_RESERVED;
				} else {
					// 일반주문
					orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.ORDER_DELIVERY_REQUEST;
				}
			} else if (StringUtils.equals(orderStatus, "60")) {
				// 배달완료
				orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.ORDER_DELIVERY_COMPLETED;
			}
		} else {
			// 포장주문
			if (StringUtils.equals(orderInfo.getOrderStatus(), "10")) {
				if (isReservedOrder) {
					// 예약주문
					orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.ORDER_PICKUP_RESERVED;
				} else {
					// 일반주문
					orderMessageSendType = ORDER_MESSAGE_SEND_TYPE.ORDER_PICKUP_REQUEST;
				}
			}
		}
		return orderMessageSendType;
	}

}
