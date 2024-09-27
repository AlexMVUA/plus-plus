package com.example.transformer.impl;

import com.example.transformer.ResultTransformer;

import java.util.ArrayList;
import java.util.List;

import static com.example.Constants.BUZZ;
import static com.example.Constants.FIZZ;
import static com.example.Constants.FIZZ_BUZZ;
import static com.example.Constants.PLUS_CHAR;

public class PlusPlusTransformer implements ResultTransformer<List<String>> {

    @Override
    public List<String> transform(List<String> source) {
        if (source.isEmpty()) {
            return source;
        }
        int fizzCounter = 0;
        int buzzCounter = 0;
        int fizzBuzzCounter = 0;

        List<String> result = new ArrayList<>();

        for (String element : source) {
            switch (element) {
                case FIZZ: {
                    if (buzzCounter > 0 || fizzBuzzCounter > 0) {
                        buzzCounter = 0;
                        fizzBuzzCounter = 0;
                        fizzCounter++;
                        result.add(element);
                    } else {
                        result.add(element + PLUS_CHAR.repeat(fizzCounter++));
                    }
                    break;
                }
                case BUZZ: {
                    if (fizzCounter > 0 || fizzBuzzCounter > 0) {
                        buzzCounter++;
                        fizzCounter = 0;
                        fizzBuzzCounter = 0;
                        result.add(element);
                    } else {
                        result.add(element + PLUS_CHAR.repeat(buzzCounter++));
                    }
                    break;
                }
                case FIZZ_BUZZ: {
                    fizzCounter = 0;
                    buzzCounter = 0;
                    fizzBuzzCounter++;
                    result.add(element);
                    break;
                }
                default: {
                    result.add(element);
                    break;
                }
            }
        }
        return result;
    }
}
