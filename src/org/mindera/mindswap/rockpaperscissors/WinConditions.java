package org.mindera.mindswap.rockpaperscissors;

public enum WinConditions {
    WINS(1),
    DRAW(0),
    LOSE(-1);

    private final int state;

    WinConditions(int state) {
        this.state = state;

    }

    public int getState() {
        return state;
    }


}
