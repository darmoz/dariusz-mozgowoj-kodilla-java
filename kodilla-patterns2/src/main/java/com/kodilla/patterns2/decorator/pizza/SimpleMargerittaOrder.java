package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SimpleMargerittaOrder implements PizzaOrder {
    @Override
    public BigDecimal orderCost() {
        return new BigDecimal(15);
    }

    @Override
    public String pizzaDescriptor() {
        return "Simple Margherita (souse + cheese)";
    }
}
