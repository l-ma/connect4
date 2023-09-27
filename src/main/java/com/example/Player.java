package com.example;

public abstract class Player {
    private static int numOfPlayer = 0;
    private int playerId;
    private Checker color;

    /**
     * Creates a new {@Player} with a specified player id
     *
     * @param playerId the player id for the player being created
     */
    public Player(int playerId) {
        this.playerId = playerId;
        this.color = (playerId == 1) ? Checker.YELLOW : Checker.RED;
    }

    /**
     * Creates a new {@Player}
     */
    public Player() {
        this.playerId = ++numOfPlayer;
        if (playerId % 2 == 0) {
            color = Checker.RED;
        } else {
            color = Checker.YELLOW;
        }
    }

    /**
     * Drops a checker into the board specified by the player
     *
     * @return an array containing the coordinates for the position to drop a piece
     */
    abstract int[] dropChecker();

    /**
     * Gets the playerId
     * @return the id of the player
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Gets the color of the pieces for this player
     *
     * @return the color for the player
     */
    public Checker getCheckerColor() {
        return color;
    }

}
