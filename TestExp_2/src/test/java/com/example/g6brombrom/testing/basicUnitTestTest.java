package com.example.g6brombrom.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class basicUnitTestTest {

    basicUnitTest calc = new basicUnitTest();

    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {

        assertEquals(2, calc.add(1, 1), "1 + 1 should equal 2");
    }
    @Test
    @DisplayName("1 + 21 != 10")
    void notQualTesgint() {

        assertNotEquals(10,calc.add(1,20),"1+20 should not equal 10");
    }
    @Test
    @DisplayName("7 + 2 = 9")
    void assertTwoNumbersAddsUp() {

        assertThat(calc.add(7,2)).isEqualTo(calc.add(7,2));
    }
}