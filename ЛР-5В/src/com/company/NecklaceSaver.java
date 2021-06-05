package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class NecklaceSaver{
    //Передаём методу объект класса Necklace
    public static void necklaceSaver(Necklace necklace) throws IOException {
        //Создаём поток вывода
        //Пытаемся записать в файл
        try {
            String path = "necklace.out";
            //Если наше ожерелье пустое, вызываем обработчик исключений
            if(necklace == null)
                throw new OutFileNotFoundException(" - is null ", path);


            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(path));
            //Записываем .out файл наш объект класса StarSystem
            objectOutputStream.writeObject(necklace);
            objectOutputStream.close();
        }
        catch (OutFileNotFoundException ex) {
            System.out.println("Message:" + ex.getWay() + ex.getMessage());
        }
    }
}
