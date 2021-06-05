package com.company;
//Интерфейс корабля, интерфейс - требования от наших кораблей, т.е. то, что умеют делать ВСЕ корабли
public interface Ship {
    //Константные значения статусов
    String statusDocked = "DOCKED";
    String statusSailing = "SAILING";

    int getMaxSpeed();              //Макс скорость
    double getCarryingCapacity();   //Грузоподъёмность
    void sailingOff();              //Отчаливание
    void mooring();                 //Причаливание
}
