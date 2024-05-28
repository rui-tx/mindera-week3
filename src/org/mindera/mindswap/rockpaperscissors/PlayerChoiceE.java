package org.mindera.mindswap.rockpaperscissors;

public enum PlayerChoiceE {
    PAPER(0, "Paper"),
    ROCK(1, "Rock"),
    SCISSOR(2, "Scissor");

    private final int value;
    private final String name;

    // constructor

    PlayerChoiceE(int value, String name) {
        this.value = value;
        this.name = name;
    }

    // gets

    public int getValue() {
        return this.value;
    }
    public String getName() {
        return this.name;
    }

    // functions

    public static PlayerChoiceE getRandomHand() {
        int hand = Random.getRandomNumber(0, PlayerChoiceE.values().length - 1); // 0 - 2
        switch (hand) {
            case 0 :
                return PAPER;
            case 1 :
                return ROCK;
            case 2 :
                return SCISSOR;
            default:
                return null;
        }
    }
}
