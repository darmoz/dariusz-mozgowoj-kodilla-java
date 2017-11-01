package com.kodilla.good.patterns.challenges.Food2Door;

public class GlutenFreeShop implements Supplier {

    private double priceForUnit;

    public GlutenFreeShop(double priceForUnit) {
        this.priceForUnit = priceForUnit;
    }

    public double getPriceForUnit() {
        return priceForUnit;
    }

    public boolean process(FoodOrder foodOrder) {
        System.out.println("GlutenFreeShop order accepted..");
        double standardPayment = foodOrder.getFoodQuantity()*getPriceForUnit();
        if (foodOrder.getFoodQuantity() > 100) {
            System.out.println("Standard payment of: " + standardPayment);
        } else  {
            System.out.println("Ordered quantity too small!");
            return false;
        }
        return true;
    }
}
