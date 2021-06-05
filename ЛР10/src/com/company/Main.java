package com.company;

public class Main {

    public static void main(String[] args) {
        //toPark - припарковать машину
        //removeCar - убрать машину с паркинга
        //Парковка реализована в виде относвязного списка
        //Удаление добавление происходит таким образом, что каждая новая машина
        //Не будет становиться в конец парковки, если есть свободные места до этого
        //Если вывело (false), значит парковочное место свободно, следующая машина станет туда
        //Если (true), значит парковочное место занято, машина туда не встанет
        //Читаем слева-направо
        Parking parking = new Parking();
        parking.toPark();
        parking.toPark();
        parking.toPark();
        parking.removeCar(3);
        parking.toPark();
        parking.removeCar(3);
        parking.toPark();
        parking.toPark();
        parking.removeCar(4);
        parking.printParking();
    }
}
