package com.kodilla.good.patterns.challenges.Food2Door;

public class Application {

    public static void main(String[] args) {

        FoodOrderRetriever foodOrderRetriever = new FoodOrderRetriever();
        FoodOrder foodOrder = foodOrderRetriever.retrieve();
        FoodOrderProcessor foodOrderProcessor = new FoodOrderProcessor(new OrderConfirmation(),
                new SupplierFoodOrderService());
        foodOrderProcessor.ordering(foodOrder);
    }
}
