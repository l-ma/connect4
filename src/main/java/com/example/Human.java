package com.example;

import java.util.Random;
import java.util.Scanner;


public class Human extends Player {
    Scanner input = new Scanner(System.in);

    /**
     * Constructor of a human
     * @param playerId id of a human
     */
    public Human(int playerId) {
        super(playerId);
    }
    /**
     * A Human input the position to drop a checker
     * @return int[] that contains[row, col]
     */
    public int[] dropChecker() {
        System.out.println("Player " + super.getPlayerId() + ": where do you want to drop your piece?");
        int row = input.nextInt();
        int col = input.nextInt();
        return new int[]{row, col};
    }
}
