package com.example;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FizzBuzzApplicationTest {

    @Test
    void shouldThrowExceptionWhenLessThan3Arguments() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> FizzBuzzApplication.main(new String[]{"a", "2"}))
                .withMessage("Minimum 3 arguments are required!");
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenAllNonParseableNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> FizzBuzzApplication.main(new String[]{"a", "b", "c"}))
                .withMessage("All passed arguments should be numbers!");
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenOneNonParseableNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> FizzBuzzApplication.main(new String[]{"a", "2", "10"}))
                .withMessage("All passed arguments should be numbers!");
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenOneParseableNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> FizzBuzzApplication.main(new String[]{"1", "a2", "1c0"}))
                .withMessage("All passed arguments should be numbers!");
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenNonNaturalNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> FizzBuzzApplication.main(new String[]{"1.6d", "1.05f", "x0cd"}))
                .withMessage("All passed arguments should be numbers!");
    }

    @Test
    void shouldRunApplication() {
        FizzBuzzApplication.main(new String[]{"2", "7", "20"});
    }


}