package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.print("Please, write arr size: ");
	Integer size = in.nextInt();
	Integer[] Arr = new Integer[size];

	System.out.print("Please, write numbers: ");
	for(int i = 0; i<size; ++i) {
	    Arr[i] = in.nextInt();
    }

	String number;
	ArrayList<Integer> result = new ArrayList<Integer>();
	for (Integer a : Arr) {
		number = a.toString();
		if (number.length() == 3 && number.charAt(0) != number.charAt(1)
				&& number.charAt(1) != number.charAt(2)
				&& number.charAt(0) != number.charAt(2)) {
			result.add(a);
		}
	}
	System.out.print("Result: " + result);
    }
}
