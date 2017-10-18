package com.kodilla.stream.lambda;


import com.kodilla.stream.lambda.CalculationProcessor;

public class CalculatorApp {
    public static void main(String[] args) {

        CalculationProcessor calculationProcessor = new CalculationProcessor();
        calculationProcessor.executeCalculation(5, 3, (a, b) -> a+b);
        calculationProcessor.executeCalculation(5,3, (a, b) -> a-b);

    }


}
