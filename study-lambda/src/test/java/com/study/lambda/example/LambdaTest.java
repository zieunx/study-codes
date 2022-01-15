package com.study.lambda.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaTest {

	/**
	 * 요구사항 1. 이벤트쿠폰은 잔액형이다.
	 * 요구사항 2. 이벤트쿠폰을 '할인되지 않는 상품들'에 적용한다.
	 * 요구사항 3. 이벤트쿠폰은 상품 전액만큼 사용하고, 잔액보다 상품금액이 크다면 잔액만큼만 적용할 수 있다.
	 * 요구사항 4. 이벤트쿠폰은 잔액을 남길 수 있다.
	 * @return
	 */
	public int updateEventCouponOnProducts(List<Product> products, int couponBalance) {
		Balance balance = new Balance(couponBalance);
		products.stream()
			.filter(Product::isNotDiscountedProduct) // 할인되지 않은 상품을 추려낸다.
			.forEach(product -> {
				int discountAmount = product.updateDiscountAmount(balance.getAmount());
				balance.minus(discountAmount);
			});

		return balance.getAmount();
	}

	@Test
	void lambdaCapturingTest() {
		List<Product> productList = List.of(
			new Product(10000, 5000), // 이미 할인된 상품
			new Product(10000, 0), // 할인되지 않은 상품
			new Product(15000, 0)); // 할인되지 않은 상품

		int discountBalance = updateEventCouponOnProducts(productList, 30000);

		assertThat(discountBalance).isEqualTo(5000);
	}
}
