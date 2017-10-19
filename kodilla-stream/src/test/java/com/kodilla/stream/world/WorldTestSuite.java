package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Set;

public class WorldTestSuite {

    @Test
    public void testWorldPeopleQuantity(){

        //Given
        Country Poland = new Country("Poland", new BigDecimal("38000000"));
        Country Germany = new Country("Germany", new BigDecimal("60000000"));
        Country UK = new Country("UK", new BigDecimal("80000000"));
        Country USA = new Country("USA", new BigDecimal("300000000"));
        Country Mexico = new Country("Mexio", new BigDecimal("120000000"));
        Country Russia = new Country("Russia", new BigDecimal("100000000"));
        Country China = new Country("China", new BigDecimal("1000000000"));
        Country Egypt = new Country("Egypt", new BigDecimal("50000000"));
        Country Congo = new Country("Congo", new BigDecimal("12000000"));

        Continent Europe = new Continent();
        Continent NorthAmerica = new Continent();
        Continent Asia = new Continent();
        Continent Africa = new Continent();

        //When
        Europe.addCountry(Poland);
        Europe.addCountry(Germany);
        Europe.addCountry(UK);
        NorthAmerica.addCountry(USA);
        NorthAmerica.addCountry(Mexico);
        Asia.addCountry(China);
        Asia.addCountry(Russia);
        Africa.addCountry(Egypt);
        Africa.addCountry(Congo);

        World World = new World();
        World.addContinent(Europe);
        World.addContinent(Asia);
        World.addContinent(NorthAmerica);
        World.addContinent(Africa);

        BigDecimal calculatedTotalPeople = World.getPeopleQuantity();


        //Then
        BigDecimal expectedTotalPeople = new BigDecimal("1760000000");
        Assert.assertEquals(expectedTotalPeople, calculatedTotalPeople);

    }
}
