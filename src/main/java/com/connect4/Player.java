package com.connect4;

/**
 * Represents a player in Connect 4.
 */
public class Player {
    private int playerId;
    private Checker color;
    private PlayerType playerType;

    /**
     * Creates a new {@code Player} with a specified player id and CheckerType
     *
     * @param playerId the player id for the player being created
     * @param checker the randomly-assigned checker type for the player
     */
    public Player(int playerId, Checker checker, PlayerType playerType) {
        this.playerId = playerId;
        this.color = checker;
        this.playerType = playerType;
    }

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
    public String getCheckerColor() {
        return color.toString();
    }

    /**
     * Gets the color of the pieces for this player
     *
     * @return the color for the player
     */
    Checker getChecker() {
        return color;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    @Override
    public String toString() {
        return "Player " + playerId;
    }

}
