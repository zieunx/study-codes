package com.test.java.javatest.immutable.step2;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /* public void setAge(int age) {
        this.age = age; // error
    }*/
}
