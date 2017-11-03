package com.kodilla.good.patterns.challenges.FligthFinder;

import java.util.HashSet;
import java.util.stream.Collectors;

public class FlightSearchServiceFrom implements FlightSearchService {

    public String search(FlightQuery flightQuery) {
        ManageDataBase manageDataBase = new ManageDataBase();
        HashSet<FlightRoutes> routeSet = manageDataBase.currentDataBase;
        FlightQueryRetriever newQuery = new FlightQueryRetriever();
        FlightQuery currentQuery = newQuery.retrieveQuery();
        String result;
        result = routeSet.stream()
                .filter(f->f.getDepartureAirport().equals(flightQuery.getFrom()))
                .map(FlightRoutes::toString)
                .collect(Collectors.joining("\n"));
        return result;

    }
}
