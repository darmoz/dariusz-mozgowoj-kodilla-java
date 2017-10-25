package com.kodilla.exception.challenge;

import com.sun.org.apache.xpath.internal.SourceTree;


public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

        /**
         * This main can throw an ArithmeticException!!!
         *
         * @param args
         */

    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            double result = firstChallenge.divide(5, 0);
            System.out.println("a/b = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is forbidden!" + e);
        } catch (Exception e) {
            double result = firstChallenge.divide(5, 0);


        } finally {
            System.out.println("Please try again");
        }
    }
 }

