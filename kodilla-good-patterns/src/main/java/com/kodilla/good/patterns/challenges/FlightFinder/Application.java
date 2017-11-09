package com.kodilla.good.patterns.challenges.FlightFinder;

public class Application {

    public static void main(String[] args) {

        FlightQueryRetriever getSearchData = new FlightQueryRetriever();
        FlightQuery queryData = getSearchData.retrieveQuery();

        FlightSearchServiceFrom newSearchFrom = new FlightSearchServiceFrom();
        String respondFrom = newSearchFrom.search(queryData);
        System.out.println(respondFrom + "\n");

        FlightSearchServiceTo  newSearchTo = new FlightSearchServiceTo();
        String respondTo = newSearchTo.search(queryData);
        System.out.println(respondTo + "\n");

        FlightSearchServiceVia newSearchVia = new FlightSearchServiceVia();
        String respondVia = newSearchVia.search(queryData);
        System.out.println(respondVia);

    }
}
