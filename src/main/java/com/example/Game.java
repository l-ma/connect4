package com.example;

public class Game {
    private Player player1;
    private Player player2;
    private Player turn;
    private Player winner;
    private Board board;
    private Display display;

    public Game(Player player1, Player player2, Display displayType) {
        this.player1 = player1;
        this.player2 = player2;
        // this.turn = pick randomly between the players;
        this.winner = null;
        this.board = new Board();
        this.display = displayType;
    }
}
