package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaOrderTestSuite {

    @Test
    public void testPizzaMargheritaCheeseXXL() {
        //Given
        PizzaOrder thePizza = new SimpleMargerittaOrder();
        thePizza = new CheesDecorator(thePizza);
        thePizza = new ExtraSizeDecorator(thePizza);
        //When
        BigDecimal totalPrice = thePizza.orderCost();
        String description = thePizza.pizzaDescriptor();
        //Then
        assertEquals(new BigDecimal(36), totalPrice);
        assertEquals("Simple Margherita (souse + cheese)+[cheese]+[XXL size]", description);
    }

    @Test
    public void testPizzaSalamiJalapenoDrink() {
        //Given
        PizzaOrder thePizza = new SimpleMargerittaOrder();
        thePizza = new SalamiDecorator(thePizza);
        thePizza = new JalaphenoDecorator(thePizza);
        thePizza = new DrinkDecorator(thePizza);
        //When
        BigDecimal totalPrice = thePizza.orderCost();
        String description = thePizza.pizzaDescriptor();
        //Then
        assertEquals(new BigDecimal(28), totalPrice);
        assertEquals("Simple Margherita (souse + cheese)+[salami]+[jalapeno]+[drink]", description);
    }

    @Test
    public void testPizzaXXLJalapenoCornOnionMushroomDrink() {
        //Given
        PizzaOrder thePizza = new SimpleMargerittaOrder();
        thePizza = new ExtraSizeDecorator(thePizza);
        thePizza = new JalaphenoDecorator(thePizza);
        thePizza = new CornDecorator(thePizza);
        thePizza = new OnionDecorator(thePizza);
        thePizza = new MushroomDecorator(thePizza);
        thePizza = new DrinkDecorator(thePizza);
        //When
        BigDecimal totalPrice = thePizza.orderCost();
        String description = thePizza.pizzaDescriptor();
        //Then
        assertEquals(new BigDecimal(40), totalPrice);
        assertEquals("Simple Margherita (souse + cheese)+[XXL size]+[jalapeno]+[corn]+[onion]+[mushrooms]+[drink]", description);
    }
}
