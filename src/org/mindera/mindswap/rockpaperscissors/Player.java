package org.mindera.mindswap.rockpaperscissors;

public class Player {

    private final String playerName;

    // current player hand ( check PlayerChoice enum )
    private PlayerChoiceE currentPlayerHand;

    // constructors

    public Player(String playerName) {
        this.playerName = playerName;
    }

    // gets

    public String getPlayerName() {
        return playerName;
    }
    public PlayerChoiceE getPlayerHand() {
        return currentPlayerHand;
    }

    // sets

    public void setCurrentPlayerHand() {
        this.currentPlayerHand = PlayerChoiceE.getRandomHand();;
    }
}