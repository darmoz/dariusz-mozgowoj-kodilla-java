package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SalamiDecorator extends AbstractPizzaOrderDecorator {
    protected SalamiDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal orderCost() {
        return super.orderCost().add(new BigDecimal(5));
    }

    @Override
    public String pizzaDescriptor() {
        return super.pizzaDescriptor() + "+[salami]";
    }
}
