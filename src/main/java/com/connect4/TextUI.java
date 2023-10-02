package com.connect4;

import java.util.Random;
import java.util.Scanner;

/**
 * Example text based client for playing Connect 4.
 * When a human player plays, they are asked to input a column
 * in which they want to drop a piece.
 */
public class TextUI {
    private Game game;
    private Scanner sc = new Scanner(System.in);
    private Scanner input = new Scanner(System.in);
    private Random random = new Random();
    /**
     * Creates a new {@code UI} instance that reads moves from the command line
     */
    public TextUI() {
        beginGame();
    }

    private void beginGame() {
        String p1 = "human";
        String p2 = "human";
        while (true) {
            System.out.println("Player 1 is a [human, computer]: ");
            p1 = readString();
            if (!(p1.equals("human") || p1.equals("computer"))) {
                System.out.println("Not a valid input, player must be a human or computer. Please try again.");
                continue;
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Player 2 is a [human, computer]: ");
            p2 = readString();
            if (!(p2.toLowerCase().equals("human") || p2.toLowerCase().equals("computer"))) {
                System.out.println("Not a valid input, player must be a human or computer. Please try again.");
                continue;
            } else {
                break;
            }
        }
        PlayerType player1 = p1.equals("human") ? PlayerType.HUMAN : PlayerType.COMPUTER;
        PlayerType player2 = p2.equals("human") ? PlayerType.HUMAN : PlayerType.COMPUTER;
        game = new Game(player1, player2);
    }

    private String readString() {
        String response = sc.nextLine().trim();
        return response;
    }

    /**
     * Runs a game until one player wins
     */
    public void playGame() {
        System.out.println(game.toString());
        while (true) {
            int col = 0;
            if (game.getCurrentPlayer().getPlayerType() == PlayerType.HUMAN) {
                System.out.println("Player " + game.getCurrentPlayer().getPlayerId() + ": which column do you want to drop your checker in?");
                col = input.nextInt();
            } else if (game.getCurrentPlayer().getPlayerType() == PlayerType.COMPUTER) {
                col = random.nextInt(7);
                System.out.println("Player " + game.getCurrentPlayer().getPlayerId() + " dropped a checker in column " + col);
            }

            try {
                game.dropChecker(col);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println(game.boardToString());
            if (game.hasWinner() || game.isBoardFull()) {
                if (game.hasWinner()) {
                    System.out.println("Congrats! " + game.getWinner() + " has won!");
                }
                if (game.isBoardFull()) {
                    System.out.println("The board is full. No one won.");
                }
                System.out.println(game.boardToString());
                System.out.println("Game finishing...");
                System.out.println("Play again? [Y/N]: ");
                String restart = readString();
                if (restart.equals("Y") || restart.equals("y")) {
                    game.newRound();
                    continue;
                }
                return;
            }
        }
    }

    public static void main(String[] args) {
        TextUI game = new TextUI();
        game.playGame();
    }
}
