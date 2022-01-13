package com.test.java.javatest.ttt;

public class TestTest {
    public static void main(String[] args) {
        String text = "현금후결제/[고객요청]추가로 요청합니다!!!";
        System.out.println(text);
        System.out.println(text.split("\\[고객요청]")[1]);
    }
}
