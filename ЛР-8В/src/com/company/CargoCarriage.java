package com.company;

public class CargoCarriage implements Carriage{
    int number;
    String destination;
    String owner;
    String status;
    double curbWeight;
    int cargoWight;

    //Тип груза
    String cargoType;
    //Максимальный вес груза
    final int maxCargoWeight = 10000;


    CargoCarriage(int number, double curbWeight) {
        this.number = number;
        this.destination = "no destination";
        this.curbWeight = curbWeight;
        this.status = statusReadyToShip;
    }

    //Загрузить грузовой вагон
    public void setCargoWeight(int cargoWeight, String cargoType) {
        if(cargoWeight > maxCargoWeight) {
            this.cargoWight = 10000;
        }
        else {
            this.cargoWight = cargoWeight;
        }
        this.cargoType = cargoType;
    }
    //Далее аналогично пассажирскому
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public String getStatus() {
        return status;
    }

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
        status = statusRepairRequired;
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
