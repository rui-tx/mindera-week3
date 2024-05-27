package org.mindera.mindswap.rockpaperscissors;

public class Player {

    private final String playerName;

    // current player hand ( rock (1), paper (0) or scissors (2) )
    private int currentPlayerHand;

    // check if player is still on the game - NOT USED
    private boolean stillOnTheGame = true;

    // constructor

    public Player(String playerName) {
        this.playerName = playerName;
    }

    // gets

    public String getPlayerName() {
        return playerName;
    }

    public int getCurrentPlayerHand() {
        return currentPlayerHand;
    }

    public boolean isStillOnTheGame() {
        return stillOnTheGame;
    }

    // sets

    public void setCurrentPlayerHand() {
        int min = 0;
        int max = 2;

        //int hand = (int) (Math.random() * (max - min + 1) + min);
        int hand = Random.getRandomNumber(min,max);
        // paper    -> 0
        // rock     -> 1
        // scissor  -> 2
        switch (hand) {
            case 0:
                this.currentPlayerHand = 0;
                break;
            case 1 :
                this.currentPlayerHand = 1;
                break;
            case 2 :
                this.currentPlayerHand = 2;
                break;
        }
    }

    // functions

    public String currentPlayerHandName() {
        String handName = "";
        // paper    -> 0
        // rock     -> 1
        // scissor  -> 2
        switch (this.currentPlayerHand) {
            case 0:
                handName = "paper";
                break;
            case 1 :
                handName = "rock";
                break;
            case 2 :
                handName = "scissor";
                break;
        }

        return handName;
    }
}