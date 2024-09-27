package com.example;

import com.example.conditions.impl.DivisibleByNumberCondition;
import com.example.transformer.ResultTransformer;
import com.example.transformer.impl.PlusPlusTransformer;

import java.util.List;

import static com.example.Constants.BUZZ;
import static com.example.Constants.FIZZ;
import static com.example.Constants.FIZZ_BUZZ;


public class FizzBuzzApplication {

    public static void main(String[] args) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Minimum 3 arguments are required!");
        }

        int f = parseNumber(args[0]);
        int b = parseNumber(args[1]);
        int t = parseNumber(args[2]);

        ResultTransformer<List<String>> transformer = new PlusPlusTransformer();

        FizzBuzzCalculator calculator = new FizzBuzzCalculator(
                transformer,
                new DivisibleByNumberCondition(f * b, FIZZ_BUZZ),
                new DivisibleByNumberCondition(f, FIZZ),
                new DivisibleByNumberCondition(b, BUZZ)
        );

        printResult(t, calculator);
    }

    private static void printResult(int t, FizzBuzzCalculator calculator) {
        calculator.calculateRange(t).forEach(
                System.out::println
        );
    }

    private static int parseNumber(String argumentToParse) {
        try {
            return Integer.parseInt(argumentToParse);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("All passed arguments should be numbers!");
        }
    }
}
