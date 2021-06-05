package com.company;

public class Main {

    public static void main(String[] args) {
        WarShip kuznetsov = new AircraftCarrier(100, "DOCKED");
        kuznetsov.sailingOff();
        kuznetsov.launchRockets(20);
        kuznetsov.mooring();
    }
}
