package com.kodilla.good.patterns.challenges.Food2Door;

public class FoodOrderRetriever {

    public FoodOrder retrieve() {

        Supplier glutenFreeShop = new GlutenFreeShop(5);
        FoodOrder glutenFreeShopOrder = new FoodOrder(glutenFreeShop, "rice", 200);
        return glutenFreeShopOrder;

    }
}
