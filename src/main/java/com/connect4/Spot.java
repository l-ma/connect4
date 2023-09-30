package com.connect4;

/**
 * Represents a spot on a board of Connect 4.
 */
class Spot {
    private int xCoord;
    private int yCoord;
    private Checker checkerType;

    /**
     * Creates new instance of a Spot. When created, a spot does not have a piece in it
     *
     * @param x the x-coordinate of the new spot
     * @param y the y-coordinate of the new spot
     */
    public Spot(int x, int y) {
        xCoord = x;
        yCoord = y;
        checkerType = Checker.CLEAR;
    }

    /**
     * Updates checker type of the spot
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