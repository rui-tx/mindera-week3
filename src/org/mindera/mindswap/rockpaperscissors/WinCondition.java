package org.mindera.mindswap.rockpaperscissors;

public enum WinCondition {
    WINS(1),
    DRAW(0),
    LOSE(-1),
    P1WINS(10),
    P2WINS(20);

    private final int state;

    // constructor

    WinCondition(int state) {
        this.state = state;
    }

    // gets

    public int getState() {
        return state;
    }
}
