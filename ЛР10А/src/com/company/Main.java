package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n1 = 0, n2 = 0;

        //задаём размерности нашим сетам
        Scanner in = new Scanner(System.in);
        System.out.println("Set-1 size (n): ");
        n1 =in.nextInt();
        System.out.println("Set-2 size (n): ");
        n2 =in.nextInt();

        //Наполняем первый сет
        System.out.println("First set:");
        Integer[] arr1 = new Integer[n1];
        for(int i = 0; i < n1; i++)
            arr1[i] = in.nextInt();

        //Наполняем второй сет
        System.out.println("Second set:");
        Integer[] arr2 = new Integer[n2];
        for(int i = 0; i < n2; i++)
            arr2[i] = in.nextInt();

        //Создаём наши основные сеты
        Set set1 = new Set(arr1);
        Set set2 = new Set(arr2);


        //Операция пересечения
        System.out.println("Crossing: " + set1.crossing(set2));

        //Операция объединения
        System.out.println("Union: " + set1.union(set2));
    }
}
