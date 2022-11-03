package com.test.java.javatest.immutable.step4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void 재할당컬렉션_외부에서_불변() {
        // when
        Address address = new Address("county", "state", "city", "zipCode");
        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(new Hobby("클라이밍"));
        hobbies.add(new Hobby("독서"));
        Person person = new Person("이름", 20, address, hobbies);

        // given
        Hobby requestHobby = new Hobby("코딩");
        hobbies.add(requestHobby);

        // then
        assertFalse(person.containsHobby(requestHobby));
    }
}