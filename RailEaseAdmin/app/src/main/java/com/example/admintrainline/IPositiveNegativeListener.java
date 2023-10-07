package com.example.admintrainline;

@FunctionalInterface
public interface IPositiveNegativeListener {

    void onPositive();

    default void onNegative() {

    }
}
