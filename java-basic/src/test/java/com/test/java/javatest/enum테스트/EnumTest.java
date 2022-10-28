package com.test.java.javatest.enum테스트;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class EnumTest {

    @Test
    void 값을_포함하지_않을_때_valueOf는_에러발생() {
        RequestFruit requestFruit = RequestFruit.APPLE;

        assertThatThrownBy(() -> Fruit.valueOf(requestFruit.name()))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void isContains_구현_값을_포함하고있는지_확인() {
        RequestFruit requestFruit = RequestFruit.APPLE;

        assertThat(Fruit.isContains(requestFruit.name())).isFalse();
    }
}