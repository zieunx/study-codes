package com.study.spring.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class BeanTest {

    private static final String NAME = "John Smith";

    @Test
    public void 동일한_bean참조시_하나의_상태가_변경되면_동일하게_값_변경됨() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("scopes.xml");

        Person personSingletonA = (Person) applicationContext.getBean("personSingleton");
        Person personSingletonB = (Person) applicationContext.getBean("personSingleton");

        personSingletonA.setName(NAME);

        assertThat(personSingletonB.getName()).isEqualTo(NAME);

        ((AbstractApplicationContext) applicationContext).close();
    }
}