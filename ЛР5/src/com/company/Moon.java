package com.company;

public class Moon {
    private String name;

    Moon(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public String toString() {
        return "Moon {\n" +
                "Name: " + this.name + "\n" +
                "}";
    }

    public int hashCode(){
        int result = name == null ? 0 : name.hashCode();
        result = result * 31 + name.hashCode();
        return result;
    }
}
