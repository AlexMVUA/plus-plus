package com.example.conditions.impl;

import com.example.conditions.Condition;

public class DivisibleByNumberCondition implements Condition<Integer> {

    private final int number;
    private final String fulfilledResult;

    public DivisibleByNumberCondition(int number, String result) {
        this.number = number;
        this.fulfilledResult = result;
    }
    @Override
    public String processWithCondition(Integer divisibleNumber) {
        if (divisibleNumber % number == 0) {
            return fulfilledResult;
        } else {
            return divisibleNumber.toString();
        }
    }
}
