package com.kodilla.good.patterns.challenges.FlightFinder;


import java.util.HashSet;

public class ManageDataBase {

    public FlightRoutes addRoute(String from, String to, String no) {
        FlightRoutes newRoute = null;
        FlightRoutes route = new FlightRoutes(from, to, no);
        newRoute = route;
        return newRoute;
    }

    DataBase data = DataBase.getInstance();
    HashSet<FlightRoutes> currentDataBase = data.createDataBase();

    public HashSet addEntry(FlightRoutes flightRoutes) {
        currentDataBase.add(flightRoutes);
        return currentDataBase;
    }


}
