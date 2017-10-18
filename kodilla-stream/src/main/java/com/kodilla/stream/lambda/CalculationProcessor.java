package com.kodilla.stream.lambda;

public class CalculationProcessor {

    public void executeCalculation(double a, double b, MathExpression mathExpression) {
        double result = mathExpression.calculateExpression(a, b);
        System.out.println("Result is " + result);
    }
}
