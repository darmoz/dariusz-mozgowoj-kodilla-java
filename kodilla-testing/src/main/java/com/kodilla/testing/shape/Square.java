package com.kodilla.testing.shape;

public class Square implements Shape {
    private double sizeParameter;
    private String name;

    public Square(String name, double sizeParameter) {
        this.sizeParameter=sizeParameter;
        this.name = name;
    }

    public double getSquareSide() {
        return sizeParameter;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        double field = sizeParameter*sizeParameter;
        return field;

    }
}
