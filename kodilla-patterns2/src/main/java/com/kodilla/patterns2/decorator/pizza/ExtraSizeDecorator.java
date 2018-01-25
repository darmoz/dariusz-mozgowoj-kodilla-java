package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraSizeDecorator extends AbstractPizzaOrderDecorator{
    protected ExtraSizeDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal orderCost() {
        return super.orderCost().multiply(new BigDecimal(2));
    }

    @Override
    public String pizzaDescriptor() {
        return super.pizzaDescriptor() + "+[XXL size]";
    }
}
