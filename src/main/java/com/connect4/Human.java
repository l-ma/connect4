package com.connect4;

import java.util.Scanner;

/**
 * Represents a player which is a human. This human player can play against another human player or a computer player.
 */
public class Human extends Player {
    Scanner input = new Scanner(System.in);

    /**
     * Creates a new {@code Player} with a specified player id and CheckerType
     *
     * @param playerId the player id for the player being created
     * @param checker the randomly-assigned checker type for the player
     */
    public Human(int playerId, Checker checker) {
        super(playerId, checker);
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
