package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class NecklaceSaver{
    //Передаём методу объект класса Necklace
    public static void necklaceSaver(Necklace necklace) throws IOException {
        //Создаём поток вывода
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("necklace.out"));
        //Записываем .out файл наш объект класса StarSystem
        objectOutputStream.writeObject(necklace);
        objectOutputStream.close();
    }
}