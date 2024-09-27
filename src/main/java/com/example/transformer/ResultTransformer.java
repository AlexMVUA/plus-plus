package com.example.transformer;

public interface ResultTransformer<T> {

    T transform(T source);
}
