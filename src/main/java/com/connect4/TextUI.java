package com.connect4;

import java.util.Scanner;

/**
 * Example text based client for playing Connect 4. When a human player plays, they are asked to first input an x-coordinate and then a y-coordinate for the spot they want to drop a piece into.
 */
public class TextUI {
    private Game game;
    private Scanner sc = new Scanner(System.in);

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
            if (!(p2.equals("human") || p2.equals("computer"))) {
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
            int[] res = game.getTurnPlayer().dropChecker();
            try {
                game.dropChecker(res[0], res[1]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println(game.toString());
            if (game.hasWinner()) {
                System.out.println("Congrats! Player " + game.getWinnerId() + " has won");
                System.out.println("Game finishing...");
                System.out.println("Play again? [Y/N]: ");
                String restart = readString();
                if (restart.equals("Y")) {
                    game.newRound();
                    continue;
                }
                return;
            }
        }
    }
}
