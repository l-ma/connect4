package com.example;

import java.util.Random;

/**
 * Represents a player which is a computer. This computer player can play against a human player or another computer player.
 */
public class Computer extends Player {
    /**
     * Creates a new {@code Computer} with a specified player id
     *
     * @param playerId the player id for the player being created
     */
    public Computer(int playerId) {
        super(playerId);
    }

    /**
     * Gets coordinates to drop a checker in some position on the board
     *
     * @return int[] that contains [row, col] which are the coordinates for the drop spot
     */
    public int[] dropChecker() {
        Random random = new Random();
        int row = random.nextInt(6);
        int column = random.nextInt(7);
        return new int[]{row, column};
    }
}
