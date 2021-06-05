package com.company;

public class PassengerCarriage implements Carriage{
    //Класс пассажирского вагона
    int number;
    String destination;
    String owner;
    String status;
    double curbWeight;
    int passengerNumber;
    //Макс кол-во пассажиров в вагоне
    final int maxPassengerNumber = 1000;

    PassengerCarriage(int number, double curbWeight) {
        this.number = number;
        this.destination = "no destination";
        this.curbWeight = curbWeight;
        this.status = statusReadyToShip;
    }

    //Совершить посадка в вагон
    public void setPassengerNumber(int passengerNumber) {
        if(passengerNumber > maxPassengerNumber)
            this.passengerNumber = 100;
        else
            this.passengerNumber = passengerNumber;
    }

    @Override
    public int getNumber() {
        return number;
    }

    //Пункт назначения
    @Override
    public String getDestination() {
        return destination;
    }

    //Владелец
    @Override
    public String getOwner() {
        return owner;
    }

    //Статус
    @Override
    public String getStatus() {
        return status;
    }

    //Снаряженная нагрузка
    @Override
    public double getCurbWeight() {
        return curbWeight;
    }

    @Override
    public void setDestination(String destination) {
        status = statusOnTheWay;
        this.destination = destination;
    }

    @Override
    public void toRepair() {
        status = statusReadyToShip;
    }

    @Override
    public void toUpload() {
        status = statusUploading;
    }

    @Override
    public void toUnload() {
        status = statusUnloading;
    }
}