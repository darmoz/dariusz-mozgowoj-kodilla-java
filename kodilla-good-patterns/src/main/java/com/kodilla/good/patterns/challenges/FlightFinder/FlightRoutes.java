package com.kodilla.good.patterns.challenges.FlightFinder;

public final class FlightRoutes {
    final String departureAirport;
    final String arrivalAirport;
    final String flightNumber;

    public FlightRoutes(final String departureAirport, final String arrivalAirport, final String flightNumber) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightNumber=flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getFlightNumber() { return flightNumber; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightRoutes that = (FlightRoutes) o;

        if (!getDepartureAirport().equals(that.getDepartureAirport())) return false;
        if (!getArrivalAirport().equals(that.getArrivalAirport())) return false;
        return getFlightNumber() != null ? getFlightNumber().equals(that.getFlightNumber()) : that.getFlightNumber() == null;
    }

    @Override
    public int hashCode() {
        int result = getDepartureAirport().hashCode();
        result = 31 * result + getArrivalAirport().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FlightRoutes{" +
                "departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                '}';
    }
}
