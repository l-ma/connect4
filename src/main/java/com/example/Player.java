package com.example;

public class Player {
    private static int numOfPlayer = 0;
    private int playerId;
    private Piece color;

    public Player(int playerId) {
        this.playerId = playerId;
        this.color = (playerId == 1) ? Piece.YELLOW : Piece.RED;
    }

    public Player() {
        this.playerId = ++numOfPlayer;
        if (playerId % 2 == 0) {
            color = Piece.RED;
        } else {
            color = Piece.YELLOW;
        }
    }

    public int getPlayerId() {
        return playerId;
    }

    public Piece getPieceColor() {
        return color;
    }
}
