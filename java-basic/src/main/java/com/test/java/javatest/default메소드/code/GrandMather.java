package com.test.java.javatest.default메소드.code;

public interface GrandMather {
    default void invoke() {
        System.out.println("GrandMather default invoke");
    }
}
