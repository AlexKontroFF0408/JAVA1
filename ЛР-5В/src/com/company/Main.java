package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Stone> stoneList = new ArrayList<Stone>();

        double totalPreciousWeight = 0, totalPreciousPrice = 0;         //Общая цена и вес драгоценных камней
        double totalSemiPreciousWeight = 0, totalSemiPreciousPrice = 0; //Общая цена и вес полудрагоценных камней

        //Всё, что связано с try и catch, относится к 5-й лабораторной работе
        //Автоматическое заполнение списка камней, параметры которых задаются случайным образом
        for(int i = 0; i < 10; i++) {
            if(i % 2 == 1) //Наполнение драгоценными камнями
                try { //Программа пытется выполнить то, что находится в фигурных скобках
                    stoneList.add(new PreciousStone(String.valueOf(i), //Случайная генерация параметров камня
                            Math.random(), Math.random()*1000, Math.random()*100));
                    //Если прозрачность камня в процентах больше 100 или меньше 0, то вызывается обработчик исключения,
                    //который находится в фигурных скобках после слова catch
                    if(stoneList.get(i).getTransparency() > 100 || stoneList.get(i).getTransparency() < 0)
                        //Выводится соответствующее сообщение и введённое число, чтобы продемонстрировать работу обработчика
                        //замени в 18-й строке "Math.random()*100" на "Math.random()*500" или "Math.random()*100-500"
                        throw new ProcentException("Transparency can't be more than 100%", stoneList.get(i).getTransparency());
                } catch(ProcentException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println(ex.getNumber());
                }
            else  //Наполнение полудрагоценными камнями
                try { //Программа пытется выполнить то, что находится в фигурных скобках
                    stoneList.add(new SemipreciousStone(String.valueOf(i),  //Случайная генерация параметров камня
                            Math.random(), Math.random()*500, Math.random()*100));
                    //Если прозрачность камня в процентах больше 100 или меньше 0, то вызывается обработчик исключения,
                    //который находится в фигурных скобках после слова catch
                    if(stoneList.get(i).getTransparency() > 100 || stoneList.get(i).getTransparency() < 0)
                        //Выводится соответствующее сообщение и введённое число, чтобы продемонстрировать работу обработчика
                        //замени в 32-й строке "Math.random()*100" на "Math.random()*500" или "Math.random()*100-500"
                        throw new ProcentException("Transparency can't be more than 100%", stoneList.get(i).getTransparency());
                } catch(ProcentException ex) {
                    System.out.println(ex.getMessage());
                    System.out.println(ex.getNumber());
                }
        }

        //-------------------------------------------------------------------
        ////ЛАБОРАТОРНАЯ РАБОТА 6
        ////СОХРАНЕНИЕ И ИЗВЛЕЧЕНИЕ КЛАССА ИЗ ФАЙЛА .OUT
        ////Вывод осуществляется в самом начале консоли
        Necklace necklace = new Necklace(stoneList);
        Necklace necklaceExtracted = new Necklace();
        necklaceExtracted = necklaceSaveExtract(necklace);
        necklaceExtracted.getStones();
        //В данной лабораторной работе реализован обработчик исключений, при
        //некорректном вводе - выводе ин формации OutFileNotFoundException
        //При сохранении в файл, если передаваемый объект пустой - ловим Exception
        //При извлекании из файла, если значение пути (path) не найдено на компьютере - ловим Exception


        //-------------------------------------------------------------------


        //Вывод полученного списка камней (вывод только их цены, т.к. если выводить всю инфу, будет громоздко)
        System.out.println("\nStone list by price:");
        for(Stone stone : stoneList)
            System.out.print(" [" + Math.round(stone.getPrice()) + "ct] "); //Значения цены выводятся с округлением

        //Пузырьковая сортировка камней по их цене
        for (int i = stoneList.size() - 1; i > 0; i--) {
            for (int k = 0; k < i; k++) {
                if (stoneList.get(k).getPrice() > stoneList.get(k + 1).getPrice()) {
                    Collections.swap(stoneList, k, k+1);
                }
            }
        }

        //Вывод отсортированного списка камней
        System.out.println("\nSorted stone list by price:");
        for(Stone stone : stoneList)
            System.out.print(" [" + Math.round(stone.getPrice()) + "ct] "); //Значения цены выводятся с округлением

        //Расчёт общей цены и веса
        for (Stone stone : stoneList)             //Цикл, пробегающий по списку
            if (stone instanceof PreciousStone) { //Если драгоценный камень
                totalPreciousWeight += stone.getWeight();   //Добавляем его вес к общему весу драгоценных камней
                totalPreciousPrice += stone.getPrice();     //Добавляем его цену к общей ценности драгоценных камней
            } else if (stone instanceof SemipreciousStone) { //Если полудрагоценный камень
                totalSemiPreciousWeight += stone.getWeight();//Добавляем его вес к общему весу полудрагоценных камней
                totalSemiPreciousPrice += stone.getPrice();//Добавляем его цену к общей ценности полудрагоценных камней
            }

        //Вывод общих масс и ценностей
        System.out.println("\nTotal weight of precious stones: " + Math.round(totalPreciousWeight) + "g" +
                "\nTotal price of precious stones: " + Math.round(totalPreciousPrice) + "ct" +
                "\n\nTotal weight of semiprecious stones: " + Math.round(totalSemiPreciousWeight) + "g" +
                "\nTotal price of semiprecious stones: " + Math.round(totalSemiPreciousPrice) + "ct");


        //Нахождение камней, по заданной прозрачности
        Scanner in = new Scanner(System.in); //Сканнер
        double transparencyMax = 0, transparencyMin = 0; //Максимальная и минимальная прозрачность
        System.out.println("\nChoose maximal transparency (%): ");
        try{ //Программа пытется выполнить то, что находится в фигурных скобках
            transparencyMax = in.nextDouble(); //Ввод максимальной прозрачности
            //Если введённая максимальная прозрачность камня в процентах больше 100 или меньше 0,
            //то вызывается обработчик исключения,
            //который находится в фигурных скобках после слова catch
            if(transparencyMax > 100 || transparencyMax < 0)
                throw new ProcentException("Transparency can't be more than 100% or less than 0%", transparencyMax);
        } catch(ProcentException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber());
        }

        System.out.println("\nChoose minimal transparency (%): ");
        try{
            transparencyMin = in.nextDouble(); //Ввод минимальной прозрачности
            //Если введённая максимальная прозрачность камня в процентах больше 100 или меньше 0,
            //то вызывается обработчик исключения,
            //который находится в фигурных скобках после слова catch в строке 111
            if(transparencyMin > 100 || transparencyMin < 0)
                throw new ProcentException("Transparency can't be more than 100% or less than 0%", transparencyMin);
            //Если введённая минимальная прозрачность камня в процентах больше максимальной введённой
            //прозрачности, то вызывается обработчик исключения,
            //который находится в фигурных скобках после слова catch в 111 строке
            if(transparencyMin > transparencyMax)
                throw new ProcentException("Minimal value can't be more than maximal!", transparencyMin);
        } catch(ProcentException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber());
        }

        System.out.println("\nResult: ");
        for(Stone stone : stoneList) { //Пробег по всем элементам списка камней, если попадает в этот диапазон - выводим
            if(stone.getTransparency() >= transparencyMin && stone.getTransparency() <= transparencyMax)
                System.out.print(" [" + Math.round(stone.getTransparency()) + "%] ");
        }
    }

    public static Necklace necklaceSaveExtract(Necklace necklace) throws IOException, ClassNotFoundException{
        //Пробуем сохранить ожерелье в .out файл
        try {
            NecklaceSaver.necklaceSaver(necklace);
        }
        //Если не получилось, ловим exception
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Пытаемся извлеч объект класса из .out файла
        try {
            Necklace necklaceRestored = NecklaceExtractor.necklaceExtractor();
            System.out.print("Extracted Necklace: ");
            necklaceRestored.getStones();

            return necklaceRestored;
        }
        //Если не получилось, ловим exception
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return necklace;
    }
}
