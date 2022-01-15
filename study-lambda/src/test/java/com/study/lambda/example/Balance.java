package com.study.lambda.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Balance {
	private int amount;

	public void minus(int minusAmount) {
		this.amount = this.amount - minusAmount;
	}
}


