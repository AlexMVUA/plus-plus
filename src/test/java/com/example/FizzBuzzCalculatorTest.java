package com.example;

import com.example.conditions.Condition;
import com.example.conditions.impl.DivisibleByNumberCondition;
import com.example.transformer.ResultTransformer;
import com.example.transformer.impl.PlusPlusTransformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FizzBuzzCalculatorTest {

    private static final int FIZZ_NUMBER = 2;
    private static final int BUZZ_NUMBER = 7;
    private static final int FIZZ_BUZZ_NUMBER = 14;

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ_BUZZ = "FizzBuzz";

    @Mock
    private ResultTransformer<List<String>> transformer;

    private FizzBuzzCalculator testInstance;

    private final Condition<Integer> fizzBuzzCondition = new DivisibleByNumberCondition(FIZZ_BUZZ_NUMBER, FIZZ_BUZZ);
    private final Condition<Integer> fizzCondition = new DivisibleByNumberCondition(FIZZ_NUMBER, FIZZ);
    private final Condition<Integer> buzzCondition = new DivisibleByNumberCondition(BUZZ_NUMBER, BUZZ);

    @BeforeEach
    void setUp() {
        testInstance = new FizzBuzzCalculator(
                transformer,
                fizzBuzzCondition,
                fizzCondition,
                buzzCondition);
    }

    @Test
    void shouldReturnNumberWhenConditionNotFulfilled() {
        String result = testInstance.calculate(1);

        assertThat(result).isEqualTo("1");
    }

    @Test
    void shouldReturnFizzWhenConditionIsFulfilled() {

        String result = testInstance.calculate(FIZZ_NUMBER);

        assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    void shouldReturnBuzzWhenFizzConditionNotFulfilledAndBuzzConditionFulfilled() {
        String result = testInstance.calculate(BUZZ_NUMBER);

        assertThat(result).isEqualTo(BUZZ);
    }

    @Test
    void shouldReturnFizzBuzzWhenFizzConditionFulfilledAndBuzzConditionFulfilled() {
        String result = testInstance.calculate(FIZZ_BUZZ_NUMBER);

        assertThat(result).isEqualTo(FIZZ_BUZZ);
    }

    @Test
    void shouldReturnProvidedNumberWhenNoConditionsSpecified() {
        testInstance = new FizzBuzzCalculator(new PlusPlusTransformer());
        String result = testInstance.calculate(FIZZ_BUZZ_NUMBER);

        assertThat(result).isEqualTo("14");
    }

    @Test
    void shouldReturnNumbersRangeWhenNoConditionsSpecified() {


        testInstance = new FizzBuzzCalculator(new PlusPlusTransformer());
        List<String> result = testInstance.calculateRange(BUZZ_NUMBER);

        assertThat(result).containsExactly("1", "2", "3", "4", "5", "6", "7");
    }

    @Test
    void shouldReturnTwoConsecutiveResultForRangeNumbers() {
        mockNoOpTransformer();

        List<String> result = testInstance.calculateRange(2);

        assertThat(result).containsExactly("1", FIZZ);
    }

    @Test
    void shouldReturnRangeWithFulfilledConditionsForRangeNumbers() {
        mockNoOpTransformer();

        List<String> result = testInstance.calculateRange(BUZZ_NUMBER);

        assertThat(result).containsExactly("1", FIZZ, "3", FIZZ, "5", FIZZ, BUZZ);
    }

    private void mockNoOpTransformer() {
        when(transformer.transform(anyList()))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
    }
}
