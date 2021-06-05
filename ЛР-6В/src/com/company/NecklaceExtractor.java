package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class NecklaceExtractor {
    public static Necklace necklaceExtractor() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("necklace.out"));
        Necklace necklaceRestored = (Necklace) objectInputStream.readObject();
        objectInputStream.close();

        return necklaceRestored;
    }
}