package com.company;

public class House {
    private static int counter = 0;
    private int id;
    private int number;
    private double square;
    private int floor;
    private int roomNumber;
    private String street;
    private String houseType;
    private int serviceLife;

    public House() {
        counter += 1;
        id = counter;
        number = id;
        square = 0;
        floor = 1;
        roomNumber = 1;
        street = "Baker Street";
        houseType = "Flat";
        serviceLife = 0;
    }

    public House(int number, int square, int floor, int roomNumber, String street, String houseType, int serviceLife) {
        counter += 1;
        id = counter;
        this.number = number;
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.street = street;
        this.houseType = houseType;
        this.serviceLife = serviceLife;
    }
    //Геттеры
    public int getId() {
        return id;
    }
    public int getNumber() {
        return number;
    }
    public double getSquare() {
        return square;
    }
    public int getFloor() {
        return floor;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public String getStreet() {
        return street;
    }
    public String getHouseType() {
        return houseType;
    }
    public int getServiceLife() {
        return serviceLife;
    }
    //Сеттеры
    public void setNumber(int number) {
        this.number = number;
    }
    public void setSquare(double square) {
        this.square = square;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
    public void setServiceLife(int serviceLife) {
        this.serviceLife = serviceLife;
    }

    //Метод toString
    @Override
    public String toString() {
        return "\nHouse {\n"
                + "id: " + id + ",\n"
                + "number: " + number + ",\n"
                + "square: " + square + ",\n"
                + "floor: " + floor + ",\n"
                + "room number: " + roomNumber + ",\n"
                + "street: " + street + ",\n"
                + "house type: " + houseType + ",\n"
                + "service life: " + serviceLife + " years.\n}\n";
    }
}
