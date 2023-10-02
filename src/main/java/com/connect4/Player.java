package com.connect4;

/**
 * Represents a player in Connect 4.
 */
public class Player {
    private int playerId;
    private Checker color;
    private PlayerType playerType;

    /**
     * Creates a new {@code Player} with a specified player id, checker color, and PlayerType
     *
     * @param playerId the player id for the player being created
     * @param checker the randomly-assigned checker color for the player
     * @param playerType the player type of the player (human or computer)
     */
    public Player(int playerId, Checker checker, PlayerType playerType) {
        this.playerId = playerId;
        this.color = checker;
        this.playerType = playerType;
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
     * Gets the color of the checker for this player
     *
     * @return the color for the player
     */
    public Checker getCheckerColor() {
        return color;
    }

    /**
     * Gets the player type of this player
     *
     * @return the playerType for the player
     */
    public PlayerType getPlayerType() {
        return playerType;
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
