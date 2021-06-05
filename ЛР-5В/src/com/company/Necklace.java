package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Necklace implements Serializable {
    private ArrayList<Stone> stoneList;

    Necklace() {
        this.stoneList = new ArrayList<>();
    }
    Necklace(ArrayList<Stone> stoneList) {
        this.stoneList = stoneList;
    }

    public void setStoneList(ArrayList<Stone> stoneList) {
        this.stoneList = stoneList;
    }

    public void getStones() {
        for(Stone stone : stoneList)
            System.out.print(" [" + Math.round(stone.getPrice()) + "ct] ");
    }

}
