package com.company;

public class Parking {
    class ParkingPlace {
        boolean occupation;
        private ParkingPlace pNext;
        ParkingPlace() {
            occupation = true;
            pNext = null;
        }
    }

    private ParkingPlace head;
    private ParkingPlace tail;
    private int count = 0;


    public void toPark() {
        ParkingPlace current = new ParkingPlace();
        if(head == null) {          //Если первого элемента нет, значит машина станет сюда
            head = current;         //она же одновременно и последней будет
            tail = current;
            count += 1;
        }
        else if(!head.occupation) { //Если машину как-то убрали с первого места, новая станет сюда
            head.occupation = true;
        }
        else {
            ParkingPlace temp = head;   //Проверяем, есть ли свободные места, прежде чем становиться в конец
            while(temp.pNext != null) {
                if(!temp.occupation)
                    break;
                temp = temp.pNext;
            }
            if(!temp.occupation)        //Если было найдено место, то мы в конец не становимся
                temp.occupation = true;

            else {
                tail.pNext = current;   //Если же место не было найдено, становимся в конец, последний элемент - новая машина
                tail = current;
                count += 1;
            }

        }


    }

    public boolean removeCar(int index) { //Удаляем по индексу машину из парковки
        if(index > count || index < 1)      //Если удалили, ставим статус парковочному месту false
            return false;
        if(index == count) {
            tail.occupation = false;
            return true;
        }
        ParkingPlace current = head;
        for(int i = 1; i < index; i++) {
            current = current.pNext;
        }
        current.occupation = false;
        return true;
    }

    public void printParking() {                         //Печатаем всю паркову
        ParkingPlace temp = new ParkingPlace();
        temp = head;
        while(temp != null) {
            System.out.print("(" + temp.occupation + ")");
            temp = temp.pNext;
        }

    }
}
