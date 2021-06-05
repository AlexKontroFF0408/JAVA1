package com.company;

public abstract class WarShip implements Ship{
    //Абстрактный класс военного корабля, который декларирует, что обязаны вополнять ВСЕ ВОЕННЫЕ корабли
    //А так же, какие поля они имеют, методы в абстрактном классе могут быть переопределены классами дальше
    final int maxSpeed = 30;
    double carryingCapacity;
    int numberOfRockets;
    String status;

    public abstract void sailingOff();      //Отчаливание
    public abstract void mooring();         // виртуальные метод
    public abstract void launchRockets(int a);
}
