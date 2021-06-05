package com.company;

public interface Carriage {//Интерфейс вагона

    //Константные значения статусов вагона
    String statusUploading = "UPLOADING";
    String statusUnloading = "UNLOADING";
    String statusOnTheWay = "ON THE WAY";
    String statusReadyToShip = "READY TO SHIP";
    String statusRepairRequired = "REPAIR REQUIRED";

    //Методы интерфейса
    int getNumber();
    String getDestination();
    String getOwner();
    String getStatus();
    double getCurbWeight();
    void setDestination(String a);

    void toRepair();
    void toUpload();
    void toUnload();
}
