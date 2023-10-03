package com.connect4;

/**
 * This class represents a player in Connect 4. Players are created by a Game when it is started.
 * This class is used to conveniently retrieve information about the players in the game.
 */
public class Player {
    private int playerId;
    private Checker color;
    private PlayerType playerType;

    /**
     * Creates a new Player with a specified player id, checker color, and PlayerType
     *
     * @param playerId the player id for the player being created
     * @param checker the checker color for the player
     * @param playerType the player type of the player
     */
    Player(int playerId, Checker checker, PlayerType playerType) {
        this.playerId = playerId;
        this.color = checker;
        this.playerType = playerType;
    }

    /**
     * Changes the player's checker color.
     *
     * @param checker the checker color to be changed to
     */
    void changeCheckerColor(Checker checker) {
        this.color = checker;
    }

    /**
     * Gets the id of this player.
     *
     * @return the id of the player
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Gets the checker color for this player.
     *
     * @return the color for the player
     */
    public String getCheckerColor() {
        return color.toString();
    }

    /**
     * Gets the checker for this player.
     *
     * @return the checker for the player
     */
    Checker getChecker() {
        return color;
    }

    /**
     * Gets the player type of this player.
     *
     * @return the player type for the player
     */
    public PlayerType getPlayerType() {
        return playerType;
    }

    /**
     * Returns a string of the player with the player id.
     *
     * @return a string representation of the player
     */
    @Override
    public String toString() {
        return "Player " + playerId;
    }

}
