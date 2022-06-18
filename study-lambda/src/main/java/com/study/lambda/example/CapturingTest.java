package com.study.lambda.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CapturingTest {
	public static void main(String[] args) throws Exception {
		List<Boolean> booleanList = new ArrayList<>();
		List<String> stringList = Arrays.asList("Hello", "World");
		Optional.ofNullable(stringList)
			.orElseThrow(Exception::new)
			.stream()
			.forEach(str -> booleanList.add(Boolean.TRUE));
	}
}
