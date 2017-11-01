package com.kodilla.good.patterns.challenges.Food2Door;

public class ExtraFoodShop implements Supplier {

    private double priceForUnit;
    private double bonusDiscount;

    public ExtraFoodShop(double priceForUnit, double bonusDiscount) {
        this.bonusDiscount = bonusDiscount;
        this.priceForUnit = priceForUnit;
    }

    public double getBonusDiscount() {
        return bonusDiscount;
    }

    public double getPriceForUnit() {
        return priceForUnit;
    }

    public boolean process(FoodOrder foodOrder) {
        System.out.println("Order accepted..");
        double bonusPayment = foodOrder.getFoodQuantity()*getPriceForUnit()*(1-getBonusDiscount());
        double standardPayment = foodOrder.getFoodQuantity()*getPriceForUnit();
        if (foodOrder.getFoodQuantity() > 10) {
            System.out.println("Payment with discount of " + getBonusDiscount() + " and equals " + bonusPayment );
        } else if(foodOrder.getFoodQuantity()<2) {
            System.out.println("Quantity too small to start operation!");
            return false;
        } else  {
            System.out.println("Standard payment of: " + standardPayment );

        }
        return true;
    }
}
