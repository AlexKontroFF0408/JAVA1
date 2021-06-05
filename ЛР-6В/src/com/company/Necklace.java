package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Necklace implements Serializable {
    private final ArrayList<Stone> stoneList;


    Necklace(ArrayList<Stone> stoneList) {
        this.stoneList = stoneList;
    }

    public void getStones() {
        for(Stone t : stoneList)
            System.out.print(t.getPrice() + " - ");
    }

}
