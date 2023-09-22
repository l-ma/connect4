package com.example;

public class Spot {
    private int xCoord;
    private int yCoord;
    private boolean isEmpty;
    private Piece pieceType;

    public Spot(int x, int y) {
        xCoord = x;
        yCoord = y;
        isEmpty = true;
        pieceType = Piece.CLEAR;
    }

    public boolean isSpotEmpty() {
        return isEmpty;
    }

    public Spot getCoordinates() {
        return new Spot(xCoord, yCoord);
    }

    public Piece getPieceType() {
        return pieceType;
    }
}
