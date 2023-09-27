package com.example;

public class Board {
    public static final int NUM_ROW = 6;
    public static final int NUM_COL = 7;
    private Spot[][] board = new Spot[NUM_ROW][NUM_COL];

    /**
     * Creates a new instance of a Connect 4 {@code Board}
     */
    public Board() {
        for (int i = 0; i < NUM_ROW; i++) {
            for (int j = 0; j < NUM_COL; j++) {
                board[i][j] = new Spot(i, j);
            }
        }
    }

    /**
     * Drops a piece into the board
     *
     * @param x the x-coordinate of the spot where the piece will be dropped
     * @param y the y-coordinate of the spot where the piece will be dropped
     * @param pieceDropped the type of piece dropped
     * @return true if the move succeeds, false otherwise
     */
    public boolean dropPiece(int x, int y, Piece pieceDropped) {
        if (!isValidMove(x, y)) {
            throw new RuntimeException("Not a valid spot");
        }
        if (board[x][y].updateSpot(pieceDropped)) {
            return true;
        }
        throw new RuntimeException("droppping clear");
    }

    /**
     * Checks if it is valid to drop a piece at a certain position on the board
     *
     * @param x the x-coordinate of the potential move
     * @param y the y-coordinate of the potential move
     * @return true if the spot (x, y) is a valid spot according to the rules of Connect 4, false otherwise
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

    private Spot getSpot(int x, int y) {
        return board[x][y];
    }

    /**
     * Checks if there is a winning piece configuration at a specific position in the board
     *
     * @param x the x-coordinate of the potential winning configuration
     * @param y the x-coordinate of the potential winning configuration
     * @return true if there is a winning configuration, false otherwise
     */
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
     * Resets the board by removing all pieces currently dropped
     */
    public void resetBoard() {
        for (int i = 0; i < NUM_ROW; i++) {
            for (int j = 0; j < NUM_COL; j++) {
                Spot spot = board[i][j];
                spot.updateSpot(Piece.CLEAR);
            }
        }
    }

    /**
     * Gets the number of rows on the board
     *
     * @return number of rows
     */
    public int getNumOfRows() {
        return NUM_ROW;
    }

    /**
     * Gets the number of columns on the board
     *
     * @return number of columns
     */
    public int getNumOfCols() {
        return NUM_COL;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < NUM_ROW; i++) {
            for (int j = 0; j < NUM_COL; j++) {
                result += board[i][j];
                result += " ";
            }
            result += "\n";
        }
        return result;
    }
}
