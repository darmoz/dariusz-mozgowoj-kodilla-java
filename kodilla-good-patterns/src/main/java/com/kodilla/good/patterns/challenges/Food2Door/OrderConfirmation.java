package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderConfirmation implements InformationService {

    public void inform(Supplier supplier, FoodOrder foodOrder) {
        if(supplier.process(foodOrder)) {
            System.out.println("Order has been completed!");
        } else {
            System.out.println("Order has been rejected");
        }
    }
}
