package com.kodilla.good.patterns.challenges.FligthFinder;

import java.util.HashSet;

public class DataBase {
    private static DataBase instance;

    private DataBase() { }

    public static DataBase getInstance() {
        if(instance==null) {
            instance=new DataBase();
        }
        return instance;
    }

    public HashSet createDataBase() {
        HashSet<FlightRoutes> flightRoutesDataBase = new HashSet<>();
        flightRoutesDataBase.add(new FlightRoutes("KRK", "WAW", "AB1234"));
        flightRoutesDataBase.add(new FlightRoutes("WRC", "WAW", "AZ1255"));
        flightRoutesDataBase.add(new FlightRoutes("KRK", "WRC", "AB1236"));
        flightRoutesDataBase.add(new FlightRoutes("WRC", "POZ", "AX2212"));
        flightRoutesDataBase.add(new FlightRoutes("POZ", "KRK", "AU1445"));
        return flightRoutesDataBase;
    }

}
