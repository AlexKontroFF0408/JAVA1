package com.company;

public class Planet {
    private String name;

    Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Planet {\n" +
                "Name: " + this.name + "\n" +
                "}";
    }

    public int hashCode(){
        int result = name == null ? 0 : name.hashCode();
        result = result * 31 + name.hashCode();
        return result;
    }
}
