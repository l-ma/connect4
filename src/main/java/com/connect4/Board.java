package com.connect4;

/**
 * Represents a board in a game of Connect 4. Each spot in the board starts by having no checker (Checker.CLEAR), and as a game progresses, more spots get filled as players drop their respective checkers.
 */
class Board {
    private static final int NUM_ROW = 6;

    private static final int NUM_COL = 7;

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

    /**
     * Gets the spot at specific row and column on the board
     * @param row the row that the spot is located
     * @param column the column that the spot is located
     * @return Spot the spot at specific row and column on the board
     */
    private Spot getSpot(int row, int column) {
        return board[row][column];
    }

    /**
     * Checks if there is a winner after dropping a checker at specific spot
     *
     * @param row the row number of the spot to be dropped
     * @param column the column number of the spot to be dropped
     * @return true if either player has successfully won the game
     */
    public boolean hasWinner(int row, int column) {
        Spot droppedSpot = getSpot(row,column);
        Checker checker = droppedSpot.getCheckerType();
        // Check for horizontal win
        int count = 0;
        for (int i = Math.max(0, column - 3); i <= Math.min(NUM_COL - 1, column + 3); i++) {
            if (checker != Checker.CLEAR && getSpot(row, i).getCheckerType() == checker) {
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
        for (int i = Math.max(0, row - 3); i <= Math.min(NUM_ROW - 1, row + 3); i++) {
            if (checker != Checker.CLEAR && getSpot(i, column).getCheckerType() == checker) {
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
        int rowStart = Math.max(0, row - 3);
        int colStart = Math.max(0, column - 3);
        int rowEnd = Math.min(NUM_ROW - 1, row + 3);
        int colEnd = Math.min(NUM_COL - 1, column + 3);
        for (int i = rowStart, col = colStart; i <= rowEnd && col <= colEnd; i++, col++) {
            if (checker != Checker.CLEAR && getSpot(i, col).getCheckerType() == checker) {
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
        rowStart = Math.max(0, row - 3);
        colStart = Math.min(NUM_COL - 1, column + 3);
        rowEnd = Math.min(NUM_ROW - 1, row + 3);
        colEnd = Math.max(0, column - 3);
        for (int i = rowStart, col = colStart; i <= rowEnd && col >= colEnd; i++, col--) {
            if (checker != Checker.CLEAR && getSpot(i, col).getCheckerType() == checker) {
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

    /**
     * It shows the board status (6 x 7 grid with checkers dropped)
     * @return String that shows the board status
     */
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
