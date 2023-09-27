package com.example;

import java.util.Random;
import java.util.Scanner;

public class Human extends Player {
    Scanner sc = new Scanner(System.in);

    public Human(int playerId) {
        super(playerId);
    }

    public int[] dropPiece() {
        System.out.println("Player " + super.getPlayerId() + ": where do you want to drop your piece?");
        int row = input.nextInt();
        int col = input.nextInt();
        return new int[]{row, col};
    }
}
