package com.example.transformer.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class PlusPlusLogicTransformerTest {

    private PlusPlusTransformer testInstance;

    @BeforeEach
    void setUp() {
        testInstance = new PlusPlusTransformer();
    }

    @Test
    void shouldReturnEmptyListWhenEmptyResultProvided() {
        assertThat(testInstance.transform(Collections.emptyList())).isEmpty();
    }

    @Test
    void shouldIncreaseCounterWhenNoInterruptionForFizz() {
        List<String> source = Arrays.asList("Fizz", "Fizz", "Fizz", "Fizz");
        assertThat(testInstance.transform(source)).containsExactly(
                "Fizz", "Fizz+", "Fizz++", "Fizz+++"
        );
    }

    @Test
    void shouldIncreaseCounterForFizzOnlyWhenNumbersAndNoInterruptionForFizz() {
        List<String> source = Arrays.asList("Fizz", "1", "2", "Fizz", "3", "4", "Fizz", "Fizz");
        assertThat(testInstance.transform(source)).containsExactly(
                "Fizz", "1", "2", "Fizz+", "3", "4", "Fizz++", "Fizz+++"
        );
    }

    @Test
    void shouldIncreaseCounterWhenNoInterruptionForBuzz() {
        List<String> source = Arrays.asList("Buzz", "Buzz", "Buzz", "Buzz");
        assertThat(testInstance.transform(source)).containsExactly(
                "Buzz", "Buzz+", "Buzz++", "Buzz+++"
        );
    }

    @Test
    void shouldIncreaseCounterForBuzzOnlyWhenNumbersAndNoInterruptionForBuzz() {
        List<String> source = Arrays.asList("Buzz", "1", "2", "Buzz", "3", "4", "Buzz", "Buzz");
        assertThat(testInstance.transform(source)).containsExactly(
                "Buzz", "1", "2", "Buzz+", "3", "4", "Buzz++", "Buzz+++"
        );
    }

    @Test
    void shouldReturnTransformedElementsWhenPlusPlusOccurred() {
        List<String> source = Arrays.asList(
                "1",
                "Fizz",
                "3",
                "Fizz",
                "5",
                "Fizz",
                "Buzz",
                "Fizz",
                "9",
                "Fizz",
                "11",
                "Fizz",
                "13",
                "FizzBuzz",
                "15",
                "Fizz",
                "17",
                "Fizz",
                "19",
                "Fizz"
        );
        String[] expectedResult = new String[]{
                "1",
                "Fizz",
                "3",
                "Fizz+",
                "5",
                "Fizz++",
                "Buzz",
                "Fizz",
                "9",
                "Fizz+",
                "11",
                "Fizz++",
                "13",
                "FizzBuzz",
                "15",
                "Fizz",
                "17",
                "Fizz+",
                "19",
                "Fizz++"
        };
        assertThat(testInstance.transform(source)).containsExactly(expectedResult);
    }
}