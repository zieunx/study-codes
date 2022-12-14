package com.test.java.javatest.default메소드.code;

public class Mather implements GrandMather, GrandMather2 {
    @Override
    public void invoke() {
        GrandMather.super.invoke();
    }
}
