package com.kodilla.testing.shape;

public class Circle implements Shape {
    private double diameter;
    private String name;
    public static double pi=3.14;

    public Circle(String name, double diameter){
        this.name = name;
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        double field = pi*diameter*diameter;
        return field;
    }

    @Override
    public String toString() {
        return name + " " + diameter;
    }
}
