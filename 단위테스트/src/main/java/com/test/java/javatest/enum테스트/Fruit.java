package com.test.java.javatest.enum테스트;

import java.util.Arrays;

//
public enum Fruit {
    BANANA("바나나"),
    CARROT("당근"),
    LEMON("레몬");

    private final String text;

    Fruit(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static boolean isContains(String enumText) {
        return Fruit.values().length > 0 && Arrays.stream(Fruit.values()).anyMatch(fruit -> fruit.name().equals(enumText));
    }
}
