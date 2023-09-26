package com.example;

import java.util.Random;

public class Computer extends Player {
    public int[] dropChecker() {
        Random random = new Random();
        int row = random.nextInt(20);
        int column = random.nextInt(20);
        return new int[]{row, column};
    }
}
