package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MushroomDecorator extends AbstractPizzaOrderDecorator {
    protected MushroomDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal orderCost() {
        return super.orderCost().add(new BigDecimal(4));
    }

    @Override
    public String pizzaDescriptor() {
        return super.pizzaDescriptor() + "+[mushrooms]";
    }
}
