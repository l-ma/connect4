import java.util.Random;
import java.util.Scanner;

public class Client {
    Random r = new Random();
    private Scanner sc = new Scanner(System.in);
    Connect4 game;

    public Client() {
        game = new Connect4();
        play();
    }

    private int readInt() {
        String response = sc.nextLine().trim();
        return Integer.valueOf(response);
    }

    private int humanPlay() {
        System.out.println("Where do you want to drop your piece?");
        int col = readInt();
        return col;
    }

    private int computerPlay() {
        System.out.println("Computer playing");
        return r.nextInt(7);
    }

    private String readString() {
        String response = sc.nextLine().trim();
        return response;
    }

    public void play() {
        int turnCounter = 0;
        while (!game.isGameOver()) {
            System.out.println(game.toString());
            int spot = turnCounter % 2 == 0 ? humanPlay() : computerPlay();
            game.placeChecker(spot);
            turnCounter++;
            System.out.println(game.toString());
            System.out.println("---------------");
        }
        System.out.println("Game over! Do you want to play again? [yes, no]");
        if (readString().equals("yes")) {
            System.out.println("can't yet");
            return;
        }
    }

    public static void main(String args[]) {
        new Client();
    }
}
