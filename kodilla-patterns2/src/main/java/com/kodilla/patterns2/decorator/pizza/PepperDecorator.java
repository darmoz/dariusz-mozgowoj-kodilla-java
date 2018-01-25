package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PepperDecorator extends AbstractPizzaOrderDecorator {
    protected PepperDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal orderCost() {
        return super.orderCost().add(new BigDecimal(2));
    }

    @Override
    public String pizzaDescriptor() {
        return super.pizzaDescriptor() + "+[pepper]";
    }
}
