package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean y = true;
        short choice = 0;

        System.out.println("Choose a variant:\n1. A\n2. B\n 3. C\nYour choice: ");
        choice = in.nextShort();

        switch (choice) {
            case 1:
                variantA(choice, in, y);
                break;
            case 2:
                variantB(in);
                break;
            case 3:
                variantC(in, choice, y);
                break;
        }


        in.close();
    }

    public static void variantA(short choice, Scanner in, boolean y) {
        ArrayList<House> houseList = new ArrayList<House>();
        while (y) {
            //ВАРИАНТ А
            //Консольное окно для выбора операции
            System.out.println("Please, choose the operation:\n " +
                    "1. Add house\n " +
                    "2. Houses with fix number of rooms\n " +
                    "3. Houses with fix number of rooms and floor\n " +
                    "4. Houses with fix square\n " +
                    "5. Exit\n" +
                    "Your choice: ");
            choice = in.nextShort();


            switch (choice) {
                case 1:
                    //Временная переменная, которая будет помещена в список
                    House temp = new House();
                    System.out.println("Please custom a house:\nNumber: ");
                    temp.setNumber(in.nextShort());
                    System.out.println("Square: ");
                    temp.setSquare(in.nextDouble());
                    System.out.println("Floor: ");
                    temp.setFloor(in.nextShort());
                    System.out.println("Number of rooms: ");
                    temp.setRoomNumber(in.nextShort());
                    System.out.println("Street: ");
                    in.nextLine();
                    temp.setStreet(in.nextLine());
                    System.out.println("Type of house: ");
                    temp.setHouseType(in.nextLine());
                    System.out.println("Service life: ");
                    temp.setServiceLife(in.nextInt());
                    houseList.add(temp);
                    break;
                case 2:
                    System.out.println("Number of rooms: ");
                    short rooms = in.nextShort();
                    for (House house : houseList) {
                        if (house.getRoomNumber() == rooms) {
                            System.out.println(house);
                        }
                    }
                    break;
                case 3:
                    short upper, lower;
                    System.out.println("Upper floor: ");
                    upper = in.nextShort();
                    System.out.println("Lower floor: ");
                    lower = in.nextShort();
                    System.out.println("Number of rooms: ");
                    rooms = in.nextShort();

                    for (House house : houseList) {
                        if (house.getRoomNumber() == rooms && house.getFloor()
                                <= upper && house.getFloor() >= lower) {
                            System.out.println(house);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Square: ");
                    double square = in.nextDouble();
                    for (House house : houseList) {
                        if (house.getSquare() > square) {
                            System.out.println(house);
                        }
                    }
                    break;
                case 5:
                    y = false;
            }
        }
    }

    public static void variantB(Scanner in) {
        Point point1 = new Point();
        Point point2 = new Point();
        int p1 = 0, k1 = 0, p2 = 0, k2 = 0;
        double t = 0;
        System.out.println("The direction is given by the equation\n" +
                "in canonical form:  y = p + k(x/2)^2\n" +
                "or\n" +
                "in parametric form: x = 2t\n" +
                "                    y = p + kt^2\n" +
                "\nPlease write a P parameter: ");
        p1 = in.nextInt();
        System.out.println("Please write a K parameter: ");
        k1 = in.nextInt();
        System.out.println("Please write a T parameter: ");
        t = in.nextDouble();
        point1.setCoords(p1, k1, t);
        System.out.println("Point speed: " + point1.getSpeed(p1, k1, t));
        System.out.println("Point Acceleration (Y): " + point1.getAcceleration(p1, k1, t));

        System.out.println("\nSECOND POINT\n" +
                "Please write a P parameter: ");
        p2 = in.nextInt();
        System.out.println("Please write a K parameter: ");
        k2 = in.nextInt();
        point2.setCoords(p2, k2, t);
        System.out.println("Distance: " + point1.getDistance(point2));
        System.out.println("Crossing: " + point1.isCrossing(p1, p2, k2, k2));
    }

    public static void variantC(Scanner in, short choice, boolean y) {
        ArrayList<Circle> circleList = new ArrayList<Circle>();
        while(y) {
            //Консольное окно для выбора операции
            System.out.println("Choose an operation:\n " +
                    "  1. Add circle\n " +
                    "  2. Circles on the line\n " +
                    "  3. Min S and P\n" +
                    "  4. Exit" +
                    "Your choice:");
            choice = in.nextShort();
            switch (choice) {
                case 1:
                    System.out.print("Circle will be created by the:\n" +
                            "   (x^2/p) + (y^2/p) = 1\n" +
                            "Please write x:\n");
                    //Ввод параметров x, y и p
                    Circle temp = new Circle();
                    temp.setX(in.nextDouble());
                    System.out.print("\nPlease write y:\n");
                    temp.setY(in.nextDouble());
                    System.out.print("\nPlease write p:\n");
                    temp.setR(Math.sqrt(in.nextDouble()));
                    temp.setS();
                    temp.setP();
                    circleList.add(temp);

                    System.out.println(temp);
                    break;
                case 2:
                    //Список, который будет содержать группы окружностей, центры которых находятся на одной прямой
                    ArrayList<ArrayList<Circle>> groups = new ArrayList<ArrayList<Circle>>();
                    int counter = 0;
                    //Нахождение прямых
                    for(int i = 0; i < circleList.size(); i++) {
                        for(int k = 0; k < circleList.size(); k++) {
                            if(circleList.get(i).isSame(circleList.get(k)))
                                continue;
                            else {
                                ArrayList<Circle> buffer = new ArrayList<Circle>();
                                buffer.add(circleList.get(i));
                                buffer.add(circleList.get(k));
                                for (int l = 0; l < circleList.size(); l++) {
                                    if (circleList.get(k).isSame(circleList.get(l))
                                            || circleList.get(i).isSame(circleList.get(l)))
                                        continue;
                                    else if ((circleList.get(l).getX() - circleList.get(i).getX())
                                            / (circleList.get(k).getX() - circleList.get(i).getX())
                                            == (circleList.get(l).getY() - circleList.get(i).getY())
                                            / (circleList.get(k).getY() - circleList.get(i).getY())) {
                                        buffer.add(circleList.get(l));
                                    } else
                                        continue;
                                }
                                groups.add(buffer);
                            }

                            counter++;
                        }
                        counter++;
                    }

                    //Удаление дубликатов точек в группах
                    for (int i = 0; i < groups.size(); i++)
                        for(int k = 0; k < groups.get(i).size(); k++)
                            for (int j = 0; j < groups.get(i).size(); j++)
                                if(j != k && groups.get(i).get(k).getX() == groups.get(i).get(j).getX()
                                        && groups.get(i).get(k).getY() == groups.get(i).get(j).getY()) {
                                    groups.get(i).remove(j);
                                    j--;
                                }

                    //Удаление дубликатов точек
                    ArrayList<Circle> buf = new ArrayList<>();
                    boolean flag = false;
                    for(int i = 0; i < groups.size(); i++) {
                        for(int k = 0; k < groups.size(); k++) {
                            if(groups.get(i) != groups.get(k) && groups.get(i).size() == groups.get(k).size()) {
                                for(int j = 0; j < groups.get(k).size(); j++)
                                    for(int l = 0; l < groups.get(k).size(); l++){
                                        if(groups.get(k).get(j).getX() == groups.get(k).get(l).getX()
                                                && groups.get(k).get(j).getY() == groups.get(k).get(l).getY())
                                            flag = true;
                                        else
                                            flag = false;
                                    }
                                if(flag){
                                    groups.remove(k);
                                    k--;
                                }
                            }
                        }
                    }

                    //Выводим группы окружностей по группам
                    for(int i = 0; i < groups.size(); i++)
                    {
                        System.out.println("Line " + i + ": ");
                        for(int k = 0; k < groups.get(i).size(); k++)
                            System.out.print("(" + groups.get(i).get(k).getX() + ", " + groups.get(i).get(k).getY() + ") - ");
                        System.out.println("\n");
                    }
                    break;
                case 3:
                    int pointer = 0;
                    System.out.println("Minimal square: ");
                    //Цикл поиска минимальной площади по списку окружностей
                    for(int i = 0; i < circleList.size() - 1; i++)
                        if(circleList.get(i).getS() > circleList.get(i + 1).getS())
                            pointer = i + 1;
                    System.out.print(circleList.get(pointer));

                    System.out.println("\nMinimal perimeter: ");
                    //Цикл поиска минимального периметра по списку окружностей
                    for(int i = 0; i < circleList.size() - 1; i++)
                        if(circleList.get(i).getP() > circleList.get(i + 1).getP())
                            pointer = i + 1;
                    System.out.print(circleList.get(pointer));
                case 4:
                    //Выход из программы
                    y = false;
                    break;
            }
        }
    }
}
