package com.company;

public class Main {

    public static void main(String[] args) {
        Catalog A = new Catalog();
        A.checkBook("Book1");
        A.takeBook("Alex", "Book1");
        A.checkBook("Book1");
        A.returnBook("Alex", "Book1");
        A.checkBook("Book1");

    }
}
