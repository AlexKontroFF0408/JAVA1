package com.company;

public class Star {
    private String name;

    Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Star {\n" +
                "Name: " + this.name + "\n" +
                "}";
    }

    public int hashCode(){
        int result = name == null ? 0 : name.hashCode();
        result = result * 31 + name.hashCode();
        return result;
    }
}
