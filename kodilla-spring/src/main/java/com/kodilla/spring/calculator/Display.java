package com.kodilla.spring.calculator;

import org.springframework.stereotype.Repository;

@Repository
public final class Display {
    public void displayValue(double val) {
        System.out.println(val);
    }
}
