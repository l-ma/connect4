package com.example;

import java.util.Random;

public class Computer extends Player {
    public int[] makeMove() {
        Random random = new Random();
        int row = random.nextInt(6);
        int column = random.nextInt(7);
        return new int[]{row, column};
    }
}
