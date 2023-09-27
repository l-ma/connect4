package com.example;

import java.util.Random;

public class Computer extends Player {
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
