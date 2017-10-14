package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private double height;
    private double baseLength;
    private String name;

    public double getHeight() {
        return height;
    }

    public double getBaseLength() {
        return baseLength;
    }

    public Triangle(String name, double height, double baseLength) {

        this.height = height;
        this.baseLength = baseLength;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        double field = (height * baseLength)/2;
        return field;
    }
}
