package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class NecklaceExtractor {
    public static Necklace necklaceExtractor() throws IOException, ClassNotFoundException {
        Necklace necklaceRestored = new Necklace();
        //Пытаемся извлечь объект класса из файла .out
        try {
            //Задаём путь к файлу
            String path = "necklace.out ";
            //Если данного пути или файла не существует, вызываем наш OutFileNotFound Exception
            //обработчик исключения
            if(!new File(path).exists())
                throw new OutFileNotFoundException(" - cant find directory ", path);

            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
            necklaceRestored = (Necklace) objectInputStream.readObject();
            objectInputStream.close();
        }
        //Ловим сообщение
        catch (OutFileNotFoundException ex) {
            System.out.println("Message:" + ex.getWay() + ex.getMessage());
        }
        return necklaceRestored;
    }
}