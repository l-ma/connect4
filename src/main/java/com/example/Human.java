package com.example;

import java.util.Scanner;

public class Human extends Player{
    Scanner input = new Scanner(System.in);
    public int[] dropChecker() {
        System.out.println("Please enter the row number: ");
        int row = input.nextInt();
        System.out.println("Please enter the column number: ");
        int column = input.nextInt();
        return new int[]{row, column};
    }
}
