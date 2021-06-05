package com.company;

public class AircraftCarrier extends WarShip{
    //Класс авианосца, как обычные класс
    //Он выполняет все методы, задекларированные в интерфейсе и абстрактном классе
    AircraftCarrier() {
        this.numberOfRockets = 0;
        this.status = "DOCKED";
    }

    AircraftCarrier(int numberOfRockets, String status) {
        this.numberOfRockets = numberOfRockets;
        this.status = status;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    @Override
    public void sailingOff() {
        status = "SAILING";
    }

    @Override
    public void mooring() {
        System.out.println(statusDocked);
        status = statusDocked;
    }

    //Запустить ракеты
    public void launchRockets(int rockets) {
        if(rockets > numberOfRockets)
            numberOfRockets = 0;
        else
            numberOfRockets = numberOfRockets - rockets;

        System.out.println(numberOfRockets + " rockets left");
    }
}

