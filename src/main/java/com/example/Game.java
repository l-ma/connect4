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

    /**
     * Check after a checker is dropped at specific position, is there a winner
     * @param x the x-coordinate of the checker
     * @param y the y-coordinate of the checker
     */
    public boolean hasWinner(int x, int y) {
        Spot droppedSpot = board.getSpot(x,y);
        Piece piece = droppedSpot.getPieceType();

        // Check for horizontal win
        int count = 0;
        for (int col = Math.max(0, y - 3); col <= Math.min(board.getNumCol() - 1, y + 3); col++) {
            if (board.getSpot(x, col).getPieceType() == piece) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check for vertical win
        count = 0;
        for (int row = Math.max(0, x - 3); row <= Math.min(board.getNumRow() - 1, x + 3); row++) {
            if (board.getSpot(row, y).getPieceType() == piece) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check for diagonal win (from top-left to bottom-right)
        count = 0;
        int rowStart = Math.max(0, x - 3);
        int colStart = Math.max(0, y - 3);
        int rowEnd = Math.min(board.getNumRow() - 1, x + 3);
        int colEnd = Math.min(board.getNumCol() - 1, y + 3);
        for (int row = rowStart, col = colStart; row <= rowEnd && col <= colEnd; row++, col++) {
            if (board.getSpot(x, col).getPieceType() == piece) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check for diagonal win (from top-right to bottom-left)
        count = 0;
        rowStart = Math.max(0, x - 3);
        colStart = Math.min(board.getNumCol() - 1, y + 3);
        rowEnd = Math.min(board.getNumRow() - 1, x + 3);
        colEnd = Math.max(0, y - 3);
        for (int row = rowStart, col = colStart; row <= rowEnd && col >= colEnd; row++, col--) {
            if (board.getSpot(x, col).getPieceType() == piece) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }

    /**
     * The game end, reset all fields
     */
    public void endGame(){
        winner = null;
        board.resetBoard();
    }


}
