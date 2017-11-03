package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.FligthFinder.FlightRoutes;

import java.util.HashSet;

public class FlightDataBase {

    public HashSet createDataBase() {
        FlightRoutes route1 = new FlightRoutes("KRK","WAW","AB1234");
        FlightRoutes route2 = new FlightRoutes("WRC","WAW","A1456");
        FlightRoutes route3 = new FlightRoutes("WAW","POZ","AX2233");
        FlightRoutes route4 = new FlightRoutes("WRC","KRK","AZ1279");

        HashSet<FlightRoutes> allRoutes = new HashSet<>();
        allRoutes.add(route1);
        allRoutes.add(route2);
        allRoutes.add(route3);
        allRoutes.add(route4);

        return allRoutes;
    }

    public FlightRoutes addRoute(String from, String to, String no) {
        FlightRoutes newRoute;
        newRoute = new FlightRoutes(from, to, no);
        return newRoute;
    }

    public void addEntry(FlightRoutes flightRoutes) {

    }
}
