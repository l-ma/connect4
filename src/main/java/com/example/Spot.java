package com.example;

public class Spot {
    private int xCoord;
    private int yCoord;
    private boolean isEmpty;
    private Piece pieceType;

    /**
     * Creates new instance of a Spot. When created, a spot does not have a piece in it.
     *
     * @param x the x-coordinate of the new spot
     * @param y the y-coordinate of the new spot
     */
    public Spot(int x, int y) {
        xCoord = x;
        yCoord = y;
        isEmpty = true;
        pieceType = Piece.CLEAR;
    }

    /**
     * Updates this spot when a piece is dropped into it.
     *
     * @param piece The type of piece dropped in
     * @return true is the update succeeded, false otherwise
     */
    public boolean updateSpot(Piece piece) {
        if (pieceType != Piece.CLEAR) {
            return false;
        }
        pieceType = piece;
        return true;
    }

    /**
     * Checks if this spot is empty.
     *
     * @return true is the spot does not have a piece in it
     */
    public boolean isEmpty() {
        return isEmpty;
    }

    /**
     * Gets the x-coordinate of this spot
     *
     * @return x-coordinate
     */
    public int getXCoordinate() {
        return xCoord;
    }

    /**
     * Gets the y-coordinate of this spot
     *
     * @return y-coordinate
     */
    public int getYCoordinate() {
        return yCoord;
    }

    /**
     * Gets the type of piece in this spot (e.g. yellow, red, clear)
     *
     * @return the type of piece
     */
    public Piece getPieceType() {
        return pieceType;
    }
}
