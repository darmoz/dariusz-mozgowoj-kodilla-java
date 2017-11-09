package com.kodilla.good.patterns.challenges.FlightFinder;

public class FlightQuery {

    private String from;
    private String to;
    private String via;

    public FlightQuery(String from, String to, String via) {
        this.from = from;
        this.to = to;
        this.via = via;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getVia() {
        return via;
    }

}
