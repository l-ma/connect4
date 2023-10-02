package com.connect4;

/**
 * Represents an instance of a Connect 4 game.
 * Connect 4 is a two-player game where each player tries to make a straight line (vertical, horizontal, or diagonal) of four of their colored checkers by dropping their checkers into a 6 x 7 grid.
 * The player with yellow checker plays first. The two players take turns playing until one of them wins, or the board is full.
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
     * @param player1Type the type of the first player (human or computer)
     * @param player2Type the type of the second player (human or computer)
     */
    public Game(PlayerType player1Type, PlayerType player2Type) {
        Checker color1 = (System.currentTimeMillis() % 2 == 1) ? Checker.YELLOW : Checker.RED;
        Checker color2 = (color1 == Checker.YELLOW)? Checker.RED: Checker.YELLOW;
        this.player1 = new Player(1, color1, player1Type);
        this.player2 = new Player(2, color2, player2Type);
        this.turn = (color1 == Checker.YELLOW)? this.player1: this.player2;
        this.winner = null;
        this.board = new Board();
    }

    /**
     * Lets current turn player drop a checker in the specified column.
     *
     * Column number starts form 0. For example, the first column of the board should be indexed as 0.
     *
     * @param column the column number in which the checker will be dropped
     * @throws RuntimeException if the column number is not within the board boundary or the column is already full
     */
    public void dropChecker(int column) {
        int row;
        // Check if the column is within the boundary and find the first empty row of this column
        if (column < 0 || column >= board.getNumOfCols()) {
            throw new RuntimeException("Not a valid column. It is not within the boundary of the board.");
        } else {
            row = board.firstEmptyRow(column);
        }
        // Check if the column is full
        if (row == -1) {
            throw new RuntimeException("This column already full.");
        }
        board.dropChecker(row, column, turn.getCheckerColor());
        if (hasWinner(row, column)) {
            winner = turn;
        }
        changeTurn();
    }

    /**
     * Helper method to change the current turn status after one player drop the checker
     */
    private void changeTurn() {
        turn = (turn == player1) ? player2 : player1;
    }

    /**
     * Helper method to check if there is a winner after dropping a checker at specific spot
     *
     * @param row the row number of the spot to be dropped
     * @param column the column number of the spot to be dropped
     * @return true if either player has successfully won the game
     */
    private boolean hasWinner(int row, int column) {
        return board.hasWinner(row, column);
    }

    /**
     * Gets the player whose turn it currently is
     *
     * @return the player whose turn it is
     * @throws RuntimeException if there is no player whose turn it is
     */
    public Player getCurrentPlayer() {
        if (turn == null) {
            throw new RuntimeException("There is no turn yet");
        }
        return turn;
    }

    /**
     * Checks if a player has won the game.
     *
     * A user will win the game when making a straight line (vertical, horizontal, or diagonal) of four of their colored checker.
     *
     * @return true if either player has successfully won the game
     */
    public boolean hasWinner() {
        if (winner != null) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the board is already full
     * @return true if the board is already full
     */
    public boolean isBoardFull() {
        return board.isBoardFull();
    }

    /**
     * Gets the player who has won the game
     *
     * @return the winning player
     * @throws RuntimeException if there is no winner
     */
    public Player getWinner() {if (winner != null) {
        return winner;
    }
        throw new RuntimeException("There is no winner");
    }

    /**
     * Ends the current round and restarts a new round for the same players.
     * In the new round, the player who starts first might be different.
     */
    public void newRound() {
        winner = null;
        board.resetBoard();
        Checker color1 = (System.currentTimeMillis() % 2 == 1) ? Checker.YELLOW : Checker.RED;
        Checker color2 = (color1 == Checker.YELLOW)? Checker.RED: Checker.YELLOW;
        player1.changeCheckerColor(color1);
        player2.changeCheckerColor(color2);
        turn = (color1 == Checker.YELLOW)? player1: player2;
    }

    /**
     * Shows the board status
     * @return String that shows the board status
     */
    public String boardStatus() {
        return board.toString();
    }

    /**
     * It shows the board status, players' representing colors, and the current game status (winner or current turn).
     *
     * @return String contains the board status, players' representing colors, and the current game status
     */
    @Override
    public String toString() {
        String res = "Board status: \n" + board.toString() + "\n";
        res += "Player 1 checker color: " + player1.getCheckerColor() + "\n";
        res += "Player 2 checker color: " + player2.getCheckerColor() + "\n";
        if (winner != null) {
            res += "Winner is " + winner + ".";
        } else {
            res += "Now is " + turn + " turn.";
        }
        return res;
    }
}
