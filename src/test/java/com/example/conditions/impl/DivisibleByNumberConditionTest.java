package com.example.conditions.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivisibleByNumberConditionTest {

    private static final String FIZZ = "Fizz";
    private DivisibleByNumberCondition testInstance;

    @BeforeEach
    void setUp() {
        testInstance = new DivisibleByNumberCondition(5, FIZZ);
    }

    @Test
    void shouldReturnPassedArgumentWhenConditionIsNotFulfilled() {
        assertThat(testInstance.processWithCondition(11)).isEqualTo("11");
    }

    @Test
    void shouldReturnFizzWhenConditionIsFulfilled() {
        assertThat(testInstance.processWithCondition(10)).isEqualTo(FIZZ);
    }
}
