package com.company;

public class Main {

    public static void main(String[] args) {
        StarSystem solar = new StarSystem("Solar");  //Создание первой звёздной системы
        StarSystem sirius = new StarSystem("Solar"); //Создание второй звёздной системы
        Planet earth = new Planet("Earth");          //Создание планеты
        Moon moon = new Moon("Moon");                //Создание спутника
        Star sun = new Star("Sun");                  //Создание Звезды
        //Исходные данные специально задаются одинаковыми, чтобы проверить работу метода equals()
        //Если нужно сделать разные звёздные системы, необходимо просто поменять значения name

        try {  //Программа пытается выполнить то, что находиться в скобках
            solar.addPlanet(earth);
            //Если в список планет Звёздной системы пытаются добавить не планету, вызывается обработчик
            //исключений
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong argument!");  //Сообщение, говорящее о неверном аргументе
        }

        try {  //Программа пытается выполнить то, что находиться в скобках
            solar.addStar(sun);
            //Если в список планет Звёздной системы пытаются добавить не звезду, вызывается обработчик
            //исключений
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong argument!");  //Сообщение, говорящее о неверном аргументе
        }

        try {  //Программа пытается выполнить то, что находиться в скобках
            solar.addMoon(moon);
            //Если в список планет Звёздной системы пытаются добавить не спутник, вызывается обработчик
            //исключений
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong argument!");  //Сообщение, говорящее о неверном аргументе
        }

        try {  //Программа пытается выполнить то, что находиться в скобках
            sirius.addPlanet(earth);
            //Если в список планет Звёздной системы пытаются добавить не планету, вызывается обработчик
            //исключений
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong argument!");  //Сообщение, говорящее о неверном аргументе
        }

        try {  //Программа пытается выполнить то, что находиться в скобках
            sirius.addStar(sun);
            //Если в список планет Звёздной системы пытаются добавить не звезду, вызывается обработчик
            //исключений
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong argument!");  //Сообщение, говорящее о неверном аргументе
        }

        try {  //Программа пытается выполнить то, что находиться в скобках
            sirius.addMoon(moon);
            //Если в список планет Звёздной системы пытаются добавить не спутник, вызывается обработчик
            //исключений
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong argument!");  //Сообщение, говорящее о неверном аргументе
        }

        System.out.println("Hash codes:");
        System.out.println(sirius.hashCode());
        System.out.println(solar.hashCode());

        System.out.println("Is equals (Solar and Sirius): " + sirius.equals(solar));

        System.out.println(solar.getName() + "'s system number of planets: \n" +
                solar.getPlanetNumber());
        System.out.println(sun.getName());
    }
}