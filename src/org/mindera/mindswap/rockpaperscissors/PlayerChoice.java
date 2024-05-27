package org.mindera.mindswap.rockpaperscissors;

public enum PlayerChoice {
    PAPER(0, "Paper"),
    ROCK(1, "Rock"),
    SCISSOR(2, "Scissor");

    private final int value;
    private final String name;

    PlayerChoice (int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
