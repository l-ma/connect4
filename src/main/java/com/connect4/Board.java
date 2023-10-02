package com.connect4;

/**
 * Represents a board in a game of Connect 4. Each spot in the board starts by having
 * no checker, and as a game progresses, more spots get filled as players drop their respective checkers.
 */
class Board {
    /**
     * Number of rows in the board
     */
    public static final int NUM_ROW = 6;

    /**
     * Number of columns in the board
     */
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
     * Drops a checker into the board
     *
     * @param row row number in which the checker will be dropped
     * @param column column number in which the checker will be dropped
     * @param checkerDropped the type of checker dropped
     * @return true if the move succeeds, false otherwise
     */
    public boolean dropChecker(int row, int column, Checker checkerDropped) {

        // Check if the checker is either Yellow or Red
        if (checkerDropped == Checker.CLEAR) {
            throw new RuntimeException("dropping clear");
        }
        board[row][column].updateChecker(checkerDropped);

        return true;
    }
    /**
     * To get the row number that the checker should be dropped
     *
     * @param column the number of column in which the checker will be dropped
     * @return int row number that a checker should be dropped. Return -1 if this column is full.
     */
    public int firstEmptyRow(int column) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][column].isEmpty()) {
                return row;
            }
        }
        return -1;
    }

    private Spot getSpot(int x, int y) {
        return board[x][y];
    }

    /**
     * Checks if there is a winning checker configuration at a specific position in the board
     *
     * @param x the x-coordinate of the potential winning configuration
     * @param y the x-coordinate of the potential winning configuration
     * @return true if there is a winning configuration, false otherwise
     */
    public boolean hasWinner(int x, int y) {
        Spot droppedSpot = getSpot(x,y);
        Checker checker = droppedSpot.getCheckerType();
        // Check for horizontal win
        int count = 0;
        for (int col = Math.max(0, y - 3); col <= Math.min(NUM_COL - 1, y + 3); col++) {
            if (checker != Checker.CLEAR && getSpot(x, col).getCheckerType() == checker) {
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
            if (checker != Checker.CLEAR && getSpot(row, y).getCheckerType() == checker) {
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
            if (checker != Checker.CLEAR && getSpot(x, col).getCheckerType() == checker) {
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
            if (checker != Checker.CLEAR && getSpot(x, col).getCheckerType() == checker) {
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
     * Check if the board is full of checkers.
     *
     * @return true if the board has no open spaces, false otherwise
     */
    public boolean isBoardFull() {
        for (int i = 0; i < NUM_COL; i++) {
            if (board[0][i].getCheckerType() == Checker.CLEAR) {
                return false;
            }
        }
        return true;
    }
    /**
     * Resets the board by removing all checkers currently dropped
     */
    public void resetBoard() {
        for (int i = 0; i < NUM_ROW; i++) {
            for (int j = 0; j < NUM_COL; j++) {
                Spot spot = board[i][j];
                spot.updateChecker(Checker.CLEAR);
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
