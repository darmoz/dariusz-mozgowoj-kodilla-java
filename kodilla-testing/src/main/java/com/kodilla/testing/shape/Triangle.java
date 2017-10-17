package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private double sizeParameter;
    private String name;

    public double getBaseLength() {
        return sizeParameter;
    }

    public Triangle(String name, double sizeParameter) {
        this.name = name;
        this.sizeParameter = sizeParameter;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        double field = (sizeParameter * sizeParameter)/4;
        return field;
    }
}
