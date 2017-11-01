package com.kodilla.good.patterns.challenges.Food2Door;

public class FoodOrder {

    private Supplier supplier;
    private String typeOfFood;
    private double foodQuantity;

    public FoodOrder(Supplier supplier, String typeOfFood, double foodQuantity) {
        this.supplier = supplier;
        this.typeOfFood = typeOfFood;
        this.foodQuantity = foodQuantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public double getFoodQuantity() {
        return foodQuantity;
    }
}
