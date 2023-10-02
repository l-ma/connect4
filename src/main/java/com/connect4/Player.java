package com.connect4;

/**
 * Represents a player in Connect 4.
 */
public class Player {
    private int playerId;
    private Checker color;

    /**
     * Creates a new {@code Player} with a specified player id and CheckerType
     *
     * @param playerId the player id for the player being created
     * @param checker the randomly-assigned checker type for the player (human or computer)
     */
    public Player(int playerId, Checker checker) {
        this.playerId = playerId;
        this.color = checker;
    }

    /**
     * Change the player's checker color
     * @param checker checker color to be changed to
     */
    public void changeCheckerColor(Checker checker) {
        this.color = checker;
    }

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

    /**
     * Shows "Player {playerId}"
     * @return String shows "Player {playerId}"
     */
    @Override
    public String toString() {
        return "Player " + playerId;
    }

}
