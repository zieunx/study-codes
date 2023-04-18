package com.study.springevent.event;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventTestSupport {
    @Autowired
    protected TestEventHandler testEventHandler;

    @BeforeEach
    public void setUp() {
        testEventHandler.clear();
    }

}
