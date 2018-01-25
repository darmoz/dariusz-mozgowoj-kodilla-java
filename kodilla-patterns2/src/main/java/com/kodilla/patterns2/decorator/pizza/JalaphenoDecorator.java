package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class JalaphenoDecorator extends AbstractPizzaOrderDecorator {
    protected JalaphenoDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal orderCost() {
        return super.orderCost().add(new BigDecimal(3));
    }

    @Override
    public String pizzaDescriptor() {
        return super.pizzaDescriptor() + "+[jalapeno]";
    }
}
