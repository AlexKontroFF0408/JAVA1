package com.company;

public class ProcentException extends Exception{
    private double number;

    public double getNumber() {
        return number;
    }

    public ProcentException (String message, double number) {
        super(message);  //Вывод сообщения, которое передаётся в метод
        this.number = number;  //Вывод введённого числа
    }

    public ProcentException (String message, int number) {
        super(message); //Вывод сообщения, которое передаётся в метод
        this.number = number; //Вывод введённого числа
    }
}
