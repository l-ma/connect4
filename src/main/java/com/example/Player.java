package com.example;

public class Player {
    private static int numOfPlayer = 0;
    private int playerId;
    private Piece color;
    Player() {
        this.playerId = ++numOfPlayer;
        if (playerId % 2 == 0) {
            color = Piece.RED;
        } else {
            color = Piece.YELLOW;
        }
    }

}
