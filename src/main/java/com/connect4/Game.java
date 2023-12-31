package com.connect4;

/**
 * This class represents an instance of a Connect 4 game. Connect 4 is a two-player game where each player tries
 * to make a straight line (vertical, horizontal, or diagonal) of four of their colored checkers by dropping
 * their checkers into a 6 x 7 grid. A randomly-chosen player plays first, with players alternating thereafter.
 */
public class Game {
    private Player player1;
    private Player player2;
    private Player turn;
    private Player winner;
    private Board board;

    /**
     * Creates a new instance of a Connect 4 Game.
     *
     * @param player1Type the type of the first player
     * @param player2Type the type of the second player
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
     * Drops a checker in the specified column. Columns are numbered,
     * starting from the very leftmost, from 0 to 6, inclusive.
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
        board.dropChecker(row, column, turn.getChecker());
        if (hasWinner(row, column)) {
            winner = turn;
        }
        changeTurn();
    }

    /**
     * Change the current turn status after one player drop the checker.
     */
    private void changeTurn() {
        turn = (turn == player1) ? player2 : player1;
    }

    /**
     * Check if there is a winner at a specific spot.
     *
     * @param row the row number of the spot to be dropped
     * @param column the column number of the spot to be dropped
     * @return true if either player has successfully won the game
     */
    private boolean hasWinner(int row, int column) {
        return board.hasWinner(row, column);
    }

    /**
     * Returns the player whose turn it currently is.
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
     * Returns the type of player whose turn it currently is.
     *
     * @return the type player whose turn it is
     * @throws RuntimeException if there is no player whose turn it is
     */
    PlayerType getCurrentPlayerType() {
        if (turn == null) {
            throw new RuntimeException("There is no turn yet");
        }
        return turn.getPlayerType();
    }

    /**
     * Checks if a player has won the game. A player wins the game by making a straight
     * line (vertical, horizontal, or diagonal) with four of their colored checkers.
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
     * Checks if the board is full of checkers.
     *
     * @return true if the board has no open spaces, false otherwise
     */
    public boolean isBoardFull() {
        return board.isBoardFull();
    }

    /**
     * Gets the player who has won the game.
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
     * Ends the current round and starts a new round for the same players. The board is cleared,
     * and whichever player played last in the previous game goes second in the next game.
     */
    public void newRound() {
        winner = null;
        board.resetBoard();
    }

    /**
     * Returns just the board as a string with no extra information about the game.
     *
     * @return string representation of the board
     */
    public String boardToString() {
        return board.toString();
    }

    /**
     * Returns the board with extra information about the game.
     *
     * @return string representation of the board with accompanying information about the game
     */
    @Override
    public String toString() {
        String res = "Board status: \n" + board.toString() + "\n";
        res += "Player 1 checker color: " + player1.getCheckerColor() + "\n";
        res += "Player 2 checker color: " + player2.getCheckerColor() + "\n";
        if (winner != null) {
            res += "Winner is " + winner + ".";
        } else {
            res += "It is " + turn + "'s turn.";
        }
        return res;
    }
}
