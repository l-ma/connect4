package com.connect4;

import java.util.Random;

/**
 * Represents a player which is a computer. This computer player can play against a human player or another computer player.
 */
public class Computer extends Player {
    /**
     * Creates a new {@code Player} with a specified player id and CheckerType
     *
     * @param playerId the player id for the player being created
     * @param checker the randomly-assigned checker type for the player
     */
    public Computer(int playerId, Checker checker) {
        super(playerId, checker);
    }

    /**
     * Gets column to drop a checker in some position on the board
     *
     * @return integer of column number in which the checker is dropped
     */
    public int dropChecker() {
        Random random = new Random();
        int column = random.nextInt(7);
        return column;
    }
}
