package com.kodilla.good.patterns.challenges.FligthFinder;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightSearchServiceVia implements FlightSearchService {
    public String search(FlightQuery flightQuery) {
        ManageDataBase manageDataBase = new ManageDataBase();
        HashSet<FlightRoutes> routeSet = manageDataBase.currentDataBase;
        FlightQueryRetriever newQuery = new FlightQueryRetriever();
        FlightQuery currentQuery = newQuery.retrieveQuery();
        String result;
        result = routeSet.stream()
                .filter(f->(f.getArrivalAirport().equals(currentQuery.getVia())
                        && f.getDepartureAirport().equals(currentQuery.getFrom()))
                        || (f.getArrivalAirport().equals(currentQuery.getTo())
                        && f.getDepartureAirport().equals(currentQuery.getVia()) )  )
                .map(FlightRoutes::toString)
                .collect(Collectors.joining("\n"));
        return result;
    }
}
