package com.company;

class OutFileNotFoundException extends Exception{
    private String way;

    public String getWay() {
        return way;
    }

    public OutFileNotFoundException(String message, String way) {
        super(message);  //Вывод сообщения, которое передаётся в метод
        this.way = way;  //Вывод введённого пути к файлу
    }
}
