package com.test.java.javatest.enum테스트;

import java.util.Arrays;

public class EnumTest {
    public static void main(String[] args) {
        RequestFruit requestFruit = RequestFruit.APPLE;

        // 요청들어오는 enum 과 비교하려는 enum 이 다를 때 에러가 발생한다.
//        System.out.println(Fruit.valueOf(requestFruit.name()).getText());

        // enum 내장 메소드를 활용하여 enum 에 비교 메소드를 만들고, enum 배열에 요청값이 포함되어있는지 확인할 수 있다.
        System.out.println("Fruit = " + (Fruit.isContains(requestFruit.name()) ? Fruit.valueOf(requestFruit.name()) : requestFruit.name()));
    }
}
