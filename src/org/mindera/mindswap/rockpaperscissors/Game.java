package org.mindera.mindswap.rockpaperscissors;

import static org.mindera.mindswap.rockpaperscissors.WinConditions.*;

public class Game {
    // paper    -> 0 -> PAPER
    // rock     -> 1 -> ROCK
    // scissor  -> 2 -> SCISSOR

    // line then column
    /*
            p   r   s
        p   0   1   -1
        r   -1  0   1
        s   1   -1  0
                            */
    // 0        -> DRAW
    // 1        -> WINS
    // -1       -> LOSE

    // this table has all the possible combinations of rock paper scissors
    private final WinConditions[][] winConditionTable = {
            {DRAW, WINS, LOSE},
            {LOSE, DRAW, WINS},
            {WINS, LOSE, DRAW}
    };

    private Player[] playerList;
    private int numberOfGames;
    private int p1Index;
    private int p2Index;
    private boolean gameEnded;

    // constructor

    public Game(Player[] playerList) {

        this.playerList = playerList;
        this.numberOfGames = 10;
        this.p1Index = 0;
        this.p2Index = 1;
        this.gameEnded = false;
    }

    // gets

    public int getNumberOfGames() {
        return numberOfGames;
    }
    public boolean isGameEnded() {
        return gameEnded;
    }

    // sets

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }

    // functions
    public void start() {
        for (int i = 1; i <= getNumberOfGames(); i++) {

            System.out.println(">>> Game number " + i + " <<<");
            while (!isGameEnded()) {

                // make hands for players
                this.playerList[p1Index].setCurrentPlayerHand();
                this.playerList[p2Index].setCurrentPlayerHand();

                // just for 2 players as of now
                WinConditions winner = decideWinner();

                // loops until it finds a winner
                if (winner != DRAW) {
                    setGameEnded(true);
                }
            }

            // ensures game is still running for the next loop
            setGameEnded(false);
            System.out.println(" ");
        }
    }

    private WinConditions decideWinner() {
        WinConditions winner;
        switch (this.obtainTheResultOfTheBattle()) {
            case LOSE:
                System.out.println(">>> Winner is " + this.playerList[p2Index].getPlayerName() + ", with " + this.playerList[p2Index].getPlayerHand().getName() + "! <<<");
                winner = P2WINS;
                break;
            case WINS:
                System.out.println(">>> Winner is " + this.playerList[p1Index].getPlayerName() + ", with " + this.playerList[p2Index].getPlayerHand().getName() + "! <<<");
                winner = P1WINS;
                break;
            default:
                System.out.println("It's a draw, let's go again!\n");
                winner = DRAW;
        }

        return winner;
    }

    private WinConditions obtainTheResultOfTheBattle() {
        return winConditionTable[this.obtainHandFromPlayer(p1Index)][this.obtainHandFromPlayer(p2Index)];
    }

    private int obtainHandFromPlayer(int player) {
        System.out.println("Player [" + player + "] has: " + this.playerList[player].getPlayerHand().getName());
        return this.playerList[player].getPlayerHand().getValue();
    }
}