package org.mindera.mindswap.rockpaperscissors;

public class Player {

    private final String playerName;

    // current player hand ( check PlayerChoice enum )
    private PlayerChoice currentPlayerHand;

    // constructors

    public Player(String playerName) {
        this.playerName = playerName;
    }

    // gets

    public String getPlayerName() {
        return playerName;
    }

    public int getCurrentPlayerHand() {
        return currentPlayerHand.getValue();
    }

    // sets

    public void setCurrentPlayerHand() {
        int min = 0;
        int max = 2;

        int hand = Random.getRandomNumber(min,max);

        switch (hand) {
            case 0 :
                this.currentPlayerHand = PlayerChoice.PAPER;
                break;
            case 1 :
                this.currentPlayerHand = PlayerChoice.ROCK;
                break;
            case 2 :
                this.currentPlayerHand = PlayerChoice.SCISSOR;
                break;
        }
    }

    // functions

    public String currentPlayerHandName() {

        return currentPlayerHand.getName();
    }
}