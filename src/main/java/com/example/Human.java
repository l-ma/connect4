package com.example;

import java.util.Scanner;

public class Human extends Player {
    Scanner sc = new Scanner(System.in);

    public Human(int playerId) {
        super(playerId);
    }

    private int readInt() {
        String response = sc.nextLine().trim();
        return Integer.valueOf(response);
    }

    public int[] dropPiece() {
        System.out.println("Player " + super.getPlayerId() + ": where do you want to drop your piece?");
        int row = readInt();
        int col = readInt();
        return new int[]{row, col};
    }
}
