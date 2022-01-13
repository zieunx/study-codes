package com.study.lambda.studylambda.official.tutorial1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class PersonTest {

    @Test
    void printPersonsTest() {
        printPersons(
                new CheckPerson() {
                    public boolean test(Person p) {
                        return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
                    }
                });
    }

    @Test
    void printPersonsTest2() {
        printPersons(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
    }

    private void printPersons(CheckPerson checkPerson) {
        log.info("checkPerson : {}", checkPerson);
    }


//    public void printPersons() {
//
//    }
}
