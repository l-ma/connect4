package com.example;

import java.util.Random;

public class Game {
    private Player player1;
    private Player player2;
    private Player turn;
    private Player winner;
    private Board board;
    Random r = new Random();

    public Game(PlayerType p1, PlayerType p2) {
        this.player1 = (p1 == PlayerType.HUMAN) ? new Human(1) : new Computer();
        this.player2 = (p2 == PlayerType.HUMAN) ? new Human(2) : new Computer();
        this.turn = (System.currentTimeMillis() % 2 == 1) ? this.player1 : this.player2;
        this.winner = null;
        this.board = new Board();
    }

    private void changeTurn() {
        turn = (turn == player1) ? player2 : player1;
    }

    public void makeMove(int x, int y) {
        board.makeMove(x, y, turn.getPieceColor());
        if (hasWinner(x, y)) {
            winner = turn;
        }
        changeTurn();
    }

    public boolean hasWinner() {
        for (int x = 0; x < board.getNumRow(); x++) {
            for (int y = 0; y < board.getNumCol(); y++) {
                if (hasWinner(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check after a checker is dropped at specific position, is there a winner
     * @param x the x-coordinate of the checker
     * @param y the y-coordinate of the checker
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

    public int getWinnerId() {
        if (getWinner() == null) {
            throw new NullPointerException("There is no winner yet");
        }
        return winner.getPlayerId();
    }

    public int getTurnId() {
        if (turn == null) {
            throw new NullPointerException("There is no turn yet");
        }
        return turn.getPlayerId();
    }

    public Player getWinner() {
        if (hasWinner()) {
            return winner;
        }
        throw new NullPointerException("There is no winner yet");
    }

    @Override
    public String toString() {
        return board.toString();
    }
}
