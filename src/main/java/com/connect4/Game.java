package com.connect4;

/**
 * Represents an instance of a Connect 4 game. Connect 4 is a two-player game where each player tries to make a straight line (vertical, horizontal, or diagonal) of four of their colored checkers by dropping their checkers into a 6 x 7 grid. A randomly-chosen player plays first, with players alternating thereafter. If the same players play multiple games in a row, they generally take turns playing first.
 */
public class Game {
    private Player player1;
    private Player player2;
    private Player turn;
    private Player winner;
    private Board board;

    /**
     * Creates a new instance of a Connect 4 Game
     *
     * @param p1 the type of the first player (human or computer)
     * @param p2 the type of the second player (human or computer)
     */
    public Game(PlayerType p1, PlayerType p2) {
        this.player1 = (p1 == PlayerType.HUMAN) ? new Human(1) : new Computer(1);
        this.player2 = (p2 == PlayerType.HUMAN) ? new Human(2) : new Computer(2);
        this.turn = (System.currentTimeMillis() % 2 == 1) ? this.player1 : this.player2;
        this.winner = null;
        this.board = new Board();
    }

    private void changeTurn() {
        turn = (turn == player1) ? player2 : player1;
    }

    /**
     * Drops a checker in the specified position
     *
     * @param x the x-coordinate of the spot where the checker will be dropped
     * @param y the y-coordinate of the spot where the checker will be dropped
     */
    public void dropChecker(int x, int y) {
        board.dropChecker(x, y, turn.getCheckerColor());
        if (hasWinner(x, y)) {
            winner = turn;
        }
        changeTurn();
    }

    /**
     * Checks if a player has won the game
     *
     * @return true if either player has successfully won the game
     */
    public boolean hasWinner() {
        for (int x = 0; x < board.getNumOfRows(); x++) {
            for (int y = 0; y < board.getNumOfCols(); y++) {
                if (hasWinner(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if there is a winner at a specific coorindate
     * 
     * @param x the x-coordinate of the spot to be checked
     * @param y the y-coordinate of the spot to be checked
     * @return true if either player has successfully won the game
     */
    public boolean hasWinner(int x, int y) {
        return board.hasWinner(x, y);
    }

    /**
     * Ends the current game, but is ready for another round to be played
     */
    public void newRound() {
        winner = null;
        board.resetBoard();
    }

    /**
     * Gets the player whose turn it currently is
     *
     * @return the player whose move it is
     * @throws RuntimeException if there is no player whose turn it is
     */
    public Player getCurrentPlayer() {
        if (turn == null) {
            throw new RuntimeException("There is no turn yet");
        }
        return turn;
    }

    /**
     * Gets the player who has won the game
     *
     * @return the winning player
     * @throws RuntimeException if there is no winner
     */
    public Player getWinner() {
        // if (winner != null) {
        if (hasWinner()) {
            return winner;
        }
        throw new RuntimeException("There is no winner yet");
    }

    /**
     * Gets the id for the player who has won the game
     *
     * @return the id of the winning player
     * @throws RuntimeException if there is no winner
     */
    public int getWinnerId() {
        // if (winner == null) {
        if (getWinner() == null) {
            throw new RuntimeException("There is no winner yet");
        }
        return winner.getPlayerId();
    }

    @Override
    public String toString() {
        return board.toString();
    }
}
