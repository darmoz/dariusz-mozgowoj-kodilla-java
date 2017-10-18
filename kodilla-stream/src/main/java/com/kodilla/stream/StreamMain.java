package com.kodilla.stream;

public class StreamMain {

    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

    Processor processor = new Processor();
    ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
    processor.execute(executeSaySomething);
    }

}