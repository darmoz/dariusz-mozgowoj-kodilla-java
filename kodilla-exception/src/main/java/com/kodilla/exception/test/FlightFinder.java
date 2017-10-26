package com.kodilla.exception.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightFinder {
    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String,Boolean> listOfAirports = new HashMap<>();
        listOfAirports.put("KRK", true);
        listOfAirports.put("WAR", true);
        listOfAirports.put("POZ", false);

        if(!(listOfAirports.get(flight.getArrivalAirport())
                && listOfAirports.get(flight.getDepartureAirport()))) {
            throw new RouteNotFoundException();
        }
        else {
            System.out.println("Flight from " + flight.getDepartureAirport()+
                    " to " + flight.getArrivalAirport() + " has been found!");
        }
    }
    public static void main (String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        try {
            flightFinder.findFlight(new Flight("POZ", "KRK"));
        } catch (RouteNotFoundException e) {
            System.out.println("Route does not exist!");
        } finally {
            System.out.println("Find a new route!");
        }
    }
}
