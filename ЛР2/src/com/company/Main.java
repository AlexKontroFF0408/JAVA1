package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Please, choose a variant:\n 1. A\n 2. B\nYour choice: ");
	short choice = in.nextShort();
	switch(choice) {
        case 1:
            System.out.println("Please, write arr size: ");
            int size = in.nextInt();
            boolean temp = false;

            int[] arr = new int[size];
            String str;

            System.out.println("Please, write numbers: ");
            for(int i = 0; i<size; ++i) {
                do {
                    arr[i] = in.nextInt();
                    if(arr[i] >= -9 && arr[i] <= 9)
                        System.out.println("It's a digit! Write more than 1 digit in number!");
                } while(arr[i] >= -9 && arr[i] <=9);
            }

            for(int i = 0; i<size; ++i) {
                str = Integer.toString(arr[i]);
                char[] chr = str.toCharArray();

                if(chr.length > 1) {
                    for(int k = 0; k<str.length() - 1; ++k) {
                        if(chr[k+1] - chr[k] == 1) {
                            temp = true;
                        }
                        else {
                            temp = false;
                        }
                    }
                }

                if(temp) {
                    System.out.println("\nRequired number: " + arr[i]);
                    break;
                }
            }
            break;
        case 2:
            System.out.println("Please, write size of matrix: ");
            int n = in.nextInt();
            double[][] matrix = new double[n][n];

            System.out.println("\nStart: ");
            for(int i = 0; i<n; ++i) {
                for(int k = 0; k<n; ++k) {
                    matrix[i][k] = Math.random()*2*n - n;
                    System.out.print(matrix[i][k] + "\t");
                }
                System.out.print("\n");
            }

            System.out.println("\nResult: ");
            for(int i = 0; i<n; ++i) {
                for(int k = 0; k<n; ++k) {
                    matrix[i][k] = Math.round(matrix[i][k]);
                    System.out.print(matrix[i][k] + "\t");
                }
                System.out.print("\n");
            }
    }
    }
}
