package com.test.java.javatest.immutable.step3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void 하위참조변수_변경_시_가변() {
        // when
        Address address = new Address("county", "state", "city", "zipCode");
        Person person = new Person("이름", 20, address);

        // given
        address.update("county-1", "state-1", "city-1", "zipCode-1");

        //then
        assertEquals(person.getAddress(), address);
    }

}