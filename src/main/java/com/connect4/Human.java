package com.connect4;

import java.util.Scanner;

/**
 * Represents a player which is a human. This human player can play against another human player or a computer player.
 */
public class Human extends Player {
    Scanner input = new Scanner(System.in);

    /**
     * Creates a new instance of a {@code Human} with a specified player id
     *
     * @param playerId id of a human player
     */
    public Human(int playerId) {
        super(playerId);
    }

    /**
     * Gets column to drop a checker in some position on the board
     *
     * @return integer of column number in which the checker is dropped
     */
    public int dropChecker() {
        System.out.println("Player " + super.getPlayerId() + ": which column do you want to drop your checker?");
        int col = input.nextInt();
        return col;
    }
}
