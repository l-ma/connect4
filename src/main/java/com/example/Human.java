package com.example;

import java.util.Random;
import java.util.Scanner;

public class Human extends Player {
    Scanner input = new Scanner(System.in);

    public Human(int playerId) {
        super(playerId);
    }

    public int[] makeMove() {
        System.out.println("Where do you want to drop your piece?");
        int row = input.nextInt();
        int col = input.nextInt();
        return new int[]{row, col};
    }
}
