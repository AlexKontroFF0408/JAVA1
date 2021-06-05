package com.company;

public class Main {

    public static void main(String[] args) {
        StarSystem solar = new StarSystem("Solar");
        solar.setProperties();
        System.out.println(solar);

        StarSystem sirius = new StarSystem("Sirius");
        sirius.setProperties();
        System.out.println(sirius);




        System.out.println(solar.hashCode());
        System.out.println(sirius.hashCode());

        System.out.println("Is equals (Solar and Sirius): " + sirius.equals(solar));

    }
}
