package com.kodilla.good.patterns.challenges.Food2Door;

public class HealthyShop implements Supplier {

    private double priceForUnit;
    private int chargeForFreshness;

    public HealthyShop(double priceForUnit, int chargeForFreshness) {
        this.priceForUnit = priceForUnit;
        this.chargeForFreshness = chargeForFreshness;
    }

    public double getPriceForUnit() {
        return priceForUnit;
    }

    public int getChargeForFreshness() {
        return chargeForFreshness;
    }

    public boolean process(FoodOrder foodOrder) {
        System.out.println("Order accepted..");
        double freshPayment = foodOrder.getFoodQuantity()*getPriceForUnit()*(1+getChargeForFreshness());
        double standardPayment = foodOrder.getFoodQuantity()*getPriceForUnit();
        if (foodOrder.getFoodQuantity() > 25) {
            System.out.println("Payment with charge for freshness of "
                    + getChargeForFreshness() + " and equals " + freshPayment );
        } else if(foodOrder.getFoodQuantity()<=25) {
            System.out.println("Quantity too small to start operation!");
            return false;
        } else  {
            System.out.println("Standard payment of: " + standardPayment );

        }
        return true;
    }
}
