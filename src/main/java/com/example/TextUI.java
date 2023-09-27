package com.example;

import java.util.Scanner;

public class TextUI {
    private Game game;
    private Scanner sc = new Scanner(System.in);
    private String[] inputs;

    /**
     * Creates a new {@link UI} instance that reads moves from the command line
     */
    public TextUI() {
        beginGame();
    }

    /**
     * Creates a new {@link UI} instance that reads moves from a passed int array containing moves
     * 
     * @param inputs the array containing the moves to be executed during the game
     */
    public TextUI(String[] inputs) {
        this.inputs = inputs;
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

    // private int readInt() {
    //     if (incr <= 1 || incr == inputs.length) {
    //         String response = sc.nextLine().trim();
    //         return Integer.valueOf(response);
    //     } else {
    //         String result = inputs[incr++].trim();
    //         System.out.println(result);
    //         return Integer.valueOf(result);
    //     }
    // }

    // private String readString() {
    //     if (incr > 1) {
    //         String response = sc.nextLine().trim();
    //         return response;
    //     } else {
    //         String result = inputs[incr++];
    //         System.out.println(result);
    //         return result;
    //     }
    // }

    private String readString() {
        String response = sc.nextLine().trim();
        return response;
    }

    private void dropChecker() {
        while (true) {
            int[] position;
            if (game.getTurnPlayer() instanceof Human) {
                Human humanPlayer = (Human)game.getTurnPlayer();
                position = humanPlayer.dropChecker();
            } else {
                Computer computerPlayer = (Computer) game.getTurnPlayer();
                position = computerPlayer.dropChecker();
            }
            int row = position[0];
            int col = position[1];
            try {
                game.dropChecker(row, col);
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
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

    public static void main(String[] args) {
        String inputs[] = {"human", "human", "5", "0", "4", "0", "5", "1", "3", "0", "5", "2", "3", "0", "2", "0", "5", "3"};
        new TextUI().playGame();
        // new TextUI(inputs).playGame();
    }
}
