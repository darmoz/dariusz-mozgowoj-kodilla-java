package com.kodilla.patterns2.decorator.txiportal;

import java.math.BigDecimal;

public class UberOrderDecorator extends AbstractTaxiOrderDecorator{
    public UberOrderDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(20));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " by Uber";
    }
}
