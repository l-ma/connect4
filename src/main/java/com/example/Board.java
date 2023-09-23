package com.example;

public class Board {
    public static final int NUM_ROW = 6;
    public static final int NUM_COL = 7;
    private Spot[][] board = new Spot[NUM_ROW][NUM_COL];

    /**
     * Drop a piece to the board
     *
     * @param x the x-coordinate of the spot where the piece will be dropped
     * @param y the y-coordinate of the spot where the piece will be dropped
     * @param pieceDropped the type of piece dropped
     * @return true if the move succeeded, false otherwise
     */
    public boolean dropPiece(int x, int y, Piece pieceDropped) {
        if (!isValidMove(x, y)) {
            return false;
        }
        if (board[x][y].updateSpot(pieceDropped)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if it is valid to drop a piece at a certain position on the board
     *
     * @param x the x-coordinate of the potential move
     * @param y the y-coordinate of the potential move
     * @return true if the spot (x, y) does not already contain a piece in it, false otherwise
     */
    public boolean isValidMove(int x, int y) {
        if (x < 0 || y < 0 || x >= NUM_ROW || y >= NUM_COL) {
            return false;
        }
        if (!board[x][y].isEmpty()) {
            return false;
        }
        for (int i = 0; i < x; i++) {
            if (board[i][y].isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
