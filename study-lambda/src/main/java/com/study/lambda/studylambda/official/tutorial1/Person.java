package com.study.lambda.studylambda.official.tutorial1;

import java.time.LocalDate;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;

    public int getAge() {
        return age;
    }

    public Sex getGender() {
        return gender;
    }

    public void printPerson() {
        // ...
    }

}
