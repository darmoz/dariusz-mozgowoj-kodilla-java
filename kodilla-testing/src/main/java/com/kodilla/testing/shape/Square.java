package com.kodilla.testing.shape;

public class Square implements Shape {
    private double squareSide;
    private String name;

    public Square(String name, double squareSide) {
        this.squareSide=squareSide;
        this.name = name;
    }

    public double getSquareSide() {
        return squareSide;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        double field = squareSide*squareSide;
        return field;

    }
}
