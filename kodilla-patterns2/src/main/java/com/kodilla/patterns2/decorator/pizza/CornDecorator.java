package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class CornDecorator extends AbstractPizzaOrderDecorator {
    protected CornDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal orderCost() {
        return super.orderCost().add(new BigDecimal(2));
    }

    @Override
    public String pizzaDescriptor() {
        return super.pizzaDescriptor() + "+[corn]";
    }
}
