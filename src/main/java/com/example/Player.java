package com.example;

public abstract class Player {
    private static int numOfPlayer = 0;
    private int playerId;
    private Piece color;

    /**
     * Creates a new {@Player} with a specified player id
     *
     * @param playerId the player id for the player being created
     */
    public Player(int playerId) {
        this.playerId = playerId;
        this.color = (playerId == 1) ? Piece.YELLOW : Piece.RED;
    }

    /**
     * Creates a new {@Player}
     */
    public Player() {
        this.playerId = ++numOfPlayer;
        if (playerId % 2 == 0) {
            color = Piece.RED;
        } else {
            color = Piece.YELLOW;
        }
    }

    /**
     * Drops a piece into the board specified by the player
     *
     * @return an array containing the coordinates for the position to drop a piece
     */
    abstract int[] dropPiece();

    public int getPlayerId() {
        return playerId;
    }

    /**
     * Gets the color of the pieces for this player
     *
     * @return the color for the player
     */
    public Piece getPieceColor() {
        return color;
    }

}
