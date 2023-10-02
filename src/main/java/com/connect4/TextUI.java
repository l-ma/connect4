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
    private String player1;
    private String player2;
    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    /**
     * Creates a new {@code UI} instance that reads moves from the command line
     */
    public TextUI() {
        beginGame();
    }

    /**
     * Begins the game by asking player types of player1 and player2
     */
    private void beginGame() {
        while (true) {
            System.out.println("Player 1 is a [human, computer]: ");
            player1 = readString();
            if (!(player1.equals("human") || player1.equals("computer"))) {
                System.out.println("Not a valid input, player must be a human or computer. Please try again.");
                continue;
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Player 2 is a [human, computer]: ");
            player2 = readString();
            if (!(player2.toLowerCase().equals("human") || player2.toLowerCase().equals("computer"))) {
                System.out.println("Not a valid input, player must be a human or computer. Please try again.");
                continue;
            } else {
                break;
            }
        }
        game = new Game();
    }

    /**
     * Helper method to read users' input
     * @return String that is trimmed
     */
    private String readString() {
        String response = sc.nextLine().trim();
        return response;
    }

    /**
     * Runs a game until one player wins or the board is full
     */
    public void playGame() {
        System.out.println(game.toString());
        while (true) {
            int col = 0;
            String currentType;
            if (game.getCurrentPlayer().getPlayerId() == 1) {
                currentType = player1;
            } else {
                currentType = player2;
            }
            if (currentType.toLowerCase().equals("human")) {
                System.out.println("Player " + game.getCurrentPlayer().getPlayerId() + ": which column do you want to drop your checker in?");
                col = Integer.parseInt(readString());
            } else if (currentType.toLowerCase().equals("computer")) {
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
