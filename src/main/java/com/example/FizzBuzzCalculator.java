package com.example;

import com.example.conditions.Condition;
import com.example.transformer.ResultTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzzCalculator {

    private static final int START_RANGE_NUMBER = 1;
    private final List<Condition<Integer>> conditions;
    private final ResultTransformer<List<String>> transformer;

    public FizzBuzzCalculator(ResultTransformer<List<String>> transformer, Condition<Integer>... conditions) {
        this.conditions = List.of(conditions);
        this.transformer = transformer;
    }

    public List<String> calculateRange(int number) {
        List<String> result = new ArrayList<>();
        if (conditions.isEmpty()) {
            return getRangeOfNumbers(number);
        }

        String calculatedResult;
        for (int i = START_RANGE_NUMBER; i <= number; i++) {
            calculatedResult = calculate(i);
            result.add(calculatedResult);
        }

        return transformer.transform(result);
    }

    private List<String> getRangeOfNumbers(int number) {
        return IntStream.range(START_RANGE_NUMBER, number + START_RANGE_NUMBER)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    String calculate(int number) {
        String result = String.valueOf(number);
        if (conditions.isEmpty()) {
            return result;
        }

        for (Condition<Integer> condition : conditions) {
            result = condition.processWithCondition(number);
            if (!result.equals(String.valueOf(number))) {
                break;
            }
        }

        return result;
    }
}
