package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main (String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1,1.5));
        } catch (Exception e) {
            System.out.println("One or more of the method assumptions failed:\nX<2 or X>=1 or Y!=1.5");

        } finally {
            System.out.println("End of the program");

        }
    }
}
