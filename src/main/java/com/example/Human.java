package com.example;

import java.util.Scanner;


public class Human extends Player {
    Scanner input = new Scanner(System.in);

    /**
     * Creates a new instance of a {@code Human}
     *
     * @param playerId id of a human player
     */
    public Human(int playerId) {
        super(playerId);
    }
    
    /**
     * Gets coordinates to drop a checker in some position on the board
     *
     * @return int[] that contains [row, col] which are the coordinates for the drop spot
     */
    public int[] dropChecker() {
        System.out.println("Player " + super.getPlayerId() + ": where do you want to drop your piece?");
        int row = input.nextInt();
        int col = input.nextInt();
        return new int[]{row, col};
    }
}
