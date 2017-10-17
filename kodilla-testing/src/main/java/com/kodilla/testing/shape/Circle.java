package com.kodilla.testing.shape;

public class Circle implements Shape {
    private double sizeParameter;
    private String name;
    public static double pi=3.14;

    public Circle(String name, double sizeParameter){
        this.name = name;
        this.sizeParameter = sizeParameter;
    }

    public double getDiameter() {
        return sizeParameter;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        double field = pi*sizeParameter*sizeParameter;
        return field;
    }

    @Override
    public String toString() {
        return name + " " + sizeParameter;
    }
}
