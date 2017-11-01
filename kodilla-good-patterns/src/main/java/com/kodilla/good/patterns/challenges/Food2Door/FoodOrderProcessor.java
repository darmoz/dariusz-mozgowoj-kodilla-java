package com.kodilla.good.patterns.challenges.Food2Door;

public class FoodOrderProcessor {

    private InformationService informationService;
    private FoodOrderService foodOrderService;

    public FoodOrderProcessor(final InformationService informationService,
                              final FoodOrderService foodOrderService) {
        this.informationService = informationService;
        this.foodOrderService=foodOrderService;
    }

    public FoodOrderDto ordering(FoodOrder foodOrder) {
        boolean isOrdered = foodOrderService.order(foodOrder.getSupplier(), foodOrder.getTypeOfFood(), foodOrder.getFoodQuantity());

        if(isOrdered) {
            informationService.inform(foodOrder.getSupplier(), foodOrder);
            return new FoodOrderDto(foodOrder, true);
        } else {
            return new FoodOrderDto(foodOrder, false);
        }

    }
}
