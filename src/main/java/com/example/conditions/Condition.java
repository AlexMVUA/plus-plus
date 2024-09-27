package com.example.conditions;


public interface Condition<T> {

    String processWithCondition(T object);
}
