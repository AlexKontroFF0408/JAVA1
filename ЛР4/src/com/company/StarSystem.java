package com.company;

import java.util.ArrayList;
import java.util.List;

public class StarSystem {
    private String name;

    private List<Star> starList = new ArrayList<>();
    private List<Planet> planetList = new ArrayList<>();
    private List<Moon> moonList = new ArrayList<>();

    StarSystem(String name) {
        try {
            this.name = name;
        } catch (IllegalArgumentException ex) {
            System.out.println("Wrong argument!");
        }
    }

    public List<Star> getStarList() {
        return starList;
    }

    public List<Planet> getPlanetList() {
        return planetList;
    }

    public List<Moon> getMoonList() {
        return moonList;
    }

    public void addPlanet(Planet planet) {
        this.planetList.add(planet);
    }

    public void addMoon(Moon moon) {
        this.moonList.add(moon);
    }

    public void addStar(Star star) {
        this.starList.add(star);
    }

    public String getName() {
        return this.name;
    }

    public int getPlanetNumber() {
        return planetList.size();
    }

    public String toString() {
        return "Star system {\n" +
                "Name: " + this.name + "\n" +
                "Number of planets: " + planetList.size() + "\n" +
                "Number of moons: " + moonList.size() + "\n" +
                "Number of stars: " + starList.size() + "\n" +
                "}";
    }


    public boolean equals(Object other) {
        //Сравниваем два объекта класса...
        if (this == other) {
            return true;
        }
        //...если это не один и тот же объект класса, идём дальше

        //Сравниваем наш объект с null...
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        //...если это не null, идём дальше

        //Создаём временный объект, приравниваем к входящему(второму) объекту
        StarSystem system = (StarSystem) other;

        //Сравниваем параметры двух объектов
        if (!getPlanetList().equals(system.getPlanetList())) {
            return false;
        }
        if (!getMoonList().equals(system.getMoonList())) {
            return false;
        }
        if (!getStarList().equals(system.getStarList())) {
            return false;
        }
        //Таким образом, если хоть один параметр отличется, возвращаем false, т.е. объекты не равны

        return getName() != null
                ? getName().equals(system.getName())
                : system.getName() == null;

    }

    public int hashCode(){
        int hash = name == null ? 0 : name.hashCode();
        hash = hash * 31 + name.hashCode();

        for (Planet planet : this.planetList)
            hash = 31 * hash + (planet == null ? 0 : planet.hashCode());
        for (Moon moon : this.moonList)
            hash = 31 * hash + (moon == null ? 0 : moon.hashCode());
        for (Star star : this.starList)
            hash = 31 * hash + (star == null ? 0 : star.hashCode());

        return hash;
    }
}