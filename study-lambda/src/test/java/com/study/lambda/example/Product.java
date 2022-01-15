package com.study.lambda.example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Product {
	private int saleAmount; // 판매금액
	private int discountAmount;

	public boolean isNotDiscountedProduct() {
		return this.discountAmount == 0;
	}

	public int updateDiscountAmount(int discountBalance) {
		 discountAmount = discountBalance - this.discountAmount > 0
			 ? this.saleAmount
			 : discountBalance;

		 return this.discountAmount;
	}
}
