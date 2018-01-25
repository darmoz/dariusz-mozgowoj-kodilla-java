package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class OnionDecorator extends AbstractPizzaOrderDecorator {
    protected OnionDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal orderCost() {
        return super.orderCost().add(new BigDecimal(1));
    }

    @Override
    public String pizzaDescriptor() {
        return super.pizzaDescriptor() + "+[onion]";
    }
}
