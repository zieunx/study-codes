package com.study.spring.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class BeanTest {

    private static final String NAME = "John Smith";
    private static final String NAME_OTHER = "Anna Jones";

    @Test
    public void singleton_같은인스턴스_참조() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("scopes.xml");

        Person personSingletonA = (Person) applicationContext.getBean("personSingleton");
        Person personSingletonB = (Person) applicationContext.getBean("personSingleton");

        personSingletonA.setName(NAME);

        assertThat(personSingletonB.getName()).isEqualTo(NAME);

        ((AbstractApplicationContext) applicationContext).close();
    }

    @Test
    public void prototype_요청할때마다_다른_인스턴스_반환() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("scopes.xml");

        Person personSingletonA = (Person) applicationContext.getBean("personPrototype");
        Person personSingletonB = (Person) applicationContext.getBean("personPrototype");

        personSingletonA.setName(NAME);
        personSingletonB.setName(NAME_OTHER);

        assertThat(personSingletonA.getName()).isEqualTo(NAME);
        assertThat(personSingletonB.getName()).isEqualTo(NAME_OTHER);

        ((AbstractApplicationContext) applicationContext).close();
    }
}