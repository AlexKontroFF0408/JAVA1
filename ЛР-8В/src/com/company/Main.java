package com.company;

public class Main {

    public static void main(String[] args) {
        PassengerCarriage pasCarriage = new PassengerCarriage(1, 200);
        CargoCarriage cargoCarriage = new CargoCarriage(1, 2500);

        System.out.println(pasCarriage.getStatus());
        pasCarriage.toUnload();
        System.out.println(pasCarriage.getStatus());
        pasCarriage.setPassengerNumber(20);

        System.out.println(cargoCarriage.getStatus());
        cargoCarriage.toUnload();
        System.out.println(cargoCarriage.getStatus());
        cargoCarriage.setCargoWeight(2000, "wood");
        System.out.println(cargoCarriage.getCurbWeight());
    }
}
