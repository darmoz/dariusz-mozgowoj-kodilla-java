package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class DrinkDecorator extends AbstractPizzaOrderDecorator {
    protected DrinkDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }
    @Override
    public BigDecimal orderCost() {
        if(super.orderCost().compareTo(BigDecimal.valueOf(25))>0) {
            return super.orderCost().add(new BigDecimal(0));
        } else {
            return super.orderCost().add(new BigDecimal(5));
        }
    }

    @Override
    public String pizzaDescriptor() {
        return super.pizzaDescriptor() + "+[drink]";
    }
}
