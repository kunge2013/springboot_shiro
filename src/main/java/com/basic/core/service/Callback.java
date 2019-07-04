package com.basic.core.service;

@FunctionalInterface
public interface Callback<T> {
    T callBack(T t);
}
