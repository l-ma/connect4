package com.connect4;

/**
 * Represents a player in Connect 4.
 */
public abstract class Player {
    private int playerId;
    private Checker color;

    /**
     * Creates a new {@code Player} with a specified player id
     *
     * @param playerId the player id for the player being created
     */
    public Player(int playerId) {
        this.playerId = playerId;
        this.color = (playerId == 1) ? Checker.YELLOW : Checker.RED;
    }

    /**
     * Drops a checker into the board specified by the player
     *
     * @return an integer of column number in which the checker is dropped
     */
    abstract int dropChecker();

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
    @Override
    public String toString() {
        return "Player " + playerId;
    }

}
