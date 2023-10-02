package com.connect4;

/**
 * Represents a spot on a board of Connect 4.
 */
class Spot {
    private int row;
    private int column;
    private Checker checkerType;

    /**
     * Creates new instance of a Spot. When created, a spot does not have a checker in it (checkerType = Checker.CLEAR)
     *
     * @param row the row number of the new spot on the board
     * @param column the column number of the new spot on the board
     */
    public Spot(int row, int column) {
        this.row = row;
        this.column = column;
        checkerType = Checker.CLEAR;
    }

    /**
     * Updates the checker type of the spot.
     *
     * @param checker The type of checker to be updated
     */
    public void updateChecker(Checker checker) {
        checkerType = checker;
    }

    /**
     * Checks if this spot is empty.
     *
     * @return true is the spot does not have a checker in it
     */
    public boolean isEmpty() {
        return checkerType == Checker.CLEAR;
    }

    /**
     * Gets the type of checker in this spot (e.g. yellow, red, clear)
     *
     * @return the type of checker
     */
    public Checker getCheckerType() {
        return checkerType;
    }

    /**
     * It shows the checker color of the spot.
     * @return String that shows the checker color of the spot
     */
    @Override
    public String toString() {
        String result = "";
        if (checkerType != Checker.CLEAR) {
            result += (checkerType == Checker.RED) ? "r" : "y";
        } else {
            result += ".";
        }
        return result;
    }
}
