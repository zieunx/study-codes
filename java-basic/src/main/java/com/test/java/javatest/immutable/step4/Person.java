package com.test.java.javatest.immutable.step4;


import java.util.*;

public class Person {
    private final String name;
    private final int age;
    private final Address address;
    private final List<Hobby> hobbies;

    public Person(String name, int age, Address address, List<Hobby> hobbies) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.hobbies = List.copyOf(hobbies);
    }

    public boolean containsHobby(Hobby hobby) {
        return hobbies.contains(hobby);
    }
}
