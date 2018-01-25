package com.kodilla.patterns2.decorator.taxiportal;

import com.kodilla.patterns2.decorator.txiportal.BasicTaxiOrder;
import com.kodilla.patterns2.decorator.txiportal.TaxiNetworkOrderDecorator;
import com.kodilla.patterns2.decorator.txiportal.TaxiOrder;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BasicTaxiPortalTestSuite {

    @Test
    public void testGetCost() {
        //Given
        BasicTaxiOrder basicTaxiOrder = new BasicTaxiOrder();
        //When
        BigDecimal cost = basicTaxiOrder.getCost();
        //Then
        assertEquals(new BigDecimal(5.0),cost);
    }

    @Test
    public void testGetDescription() {
        //Given
        BasicTaxiOrder basicTaxiOrder = new BasicTaxiOrder();
        //When
        String description = basicTaxiOrder.getDescription();
        //Then
        assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        //When
        BigDecimal cost = order.getCost();
        //Then
        assertEquals(new BigDecimal(40), cost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network", description);
    }
}
