package com.company;

public class PreciousStone extends Stone{
    private String name;
    private double weight;
    private double price;
    private double transparency;

    public PreciousStone(String name, double weight, double price, double transparency) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.transparency = transparency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getTransparency() {
        return transparency;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }
}
