package com.example;

import java.util.Random;

public class Computer extends Player {
    /**
     * A computer produce the position to drop a checker
     * @return int[] that contains[row, col]
     */
    public int[] dropChecker() {
        Random random = new Random();
        int row = random.nextInt(6);
        int column = random.nextInt(7);
        return new int[]{row, column};
    }
}
