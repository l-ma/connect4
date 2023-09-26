package com.example;

public class Board {
    public static final int NUM_ROW = 6;
    public static final int NUM_COL = 7;
    private Spot[][] board = new Spot[NUM_ROW][NUM_COL];

    /**
     * Constructor of the board, initialize each spot
     */
    public Board() {
        for (int i = 0; i < NUM_ROW; i++) {
            for (int j = 0; j < NUM_COL; j++) {
                board[i][j] = new Spot(i, j);
            }
        }
    }

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
        for (int i = x + 1; i < NUM_ROW; i++) {
            if (board[i][y].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean hasWinner(int x, int y) {
        Spot droppedSpot = getSpot(x,y);
        Piece piece = droppedSpot.getPieceType();
        // Check for horizontal win
        int count = 0;
        for (int col = Math.max(0, y - 3); col <= Math.min(NUM_COL - 1, y + 3); col++) {
            if (piece != Piece.CLEAR && getSpot(x, col).getPieceType() == piece) {
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
        for (int row = Math.max(0, x - 3); row <= Math.min(NUM_ROW - 1, x + 3); row++) {
            if (piece != Piece.CLEAR && getSpot(row, y).getPieceType() == piece) {
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
        int rowEnd = Math.min(NUM_ROW - 1, x + 3);
        int colEnd = Math.min(NUM_COL - 1, y + 3);
        for (int row = rowStart, col = colStart; row <= rowEnd && col <= colEnd; row++, col++) {
            if (piece != Piece.CLEAR && getSpot(x, col).getPieceType() == piece) {
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
        colStart = Math.min(NUM_COL - 1, y + 3);
        rowEnd = Math.min(NUM_ROW - 1, x + 3);
        colEnd = Math.max(0, y - 3);
        for (int row = rowStart, col = colStart; row <= rowEnd && col >= colEnd; row++, col--) {
            if (piece != Piece.CLEAR && getSpot(x, col).getPieceType() == piece) {
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
     * Reset the board, set each spot in the board to be Piece.CLEAR
     */
    public void resetBoard() {
        for (int i = 0; i < NUM_ROW; i++) {
            for (int j = 0; j < NUM_COL; j++) {
                Spot spot = board[i][j];
                spot.updateSpot(Piece.CLEAR);
            }
        }
    }

    public Spot getSpot(int x, int y) {
        return board[x][y];
    }

    public int getNumRow() {
        return NUM_ROW;
    }

    public int getNumCol() {
        return NUM_COL;
    }
}
