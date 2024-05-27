package org.mindera.mindswap.rockpaperscissors;

public class Game {

    private final int numberOfGames = 10;

    // paper    -> 0
    // rock     -> 1
    // scissor  -> 2

    // line then column
    /*
            p   r   s
        p   0   1   -1
        r   -1  0   1
        s   1   -1  0
                            */
    // 0        -> draw
    // 1        -> wins
    // -1       -> loses

    // this table has all the possible combinations of rock paper scissors
    private static final int WINS = 1;
    private static final int DRAW = 0;
    private static final int LOSE = -1;
    private  final int[][] winConditionTable = {
            {DRAW, WINS, LOSE},
            {LOSE, DRAW, WINS},
            {WINS, LOSE, DRAW}
    };

    public int winner;

    // game has a player objects list
    public Player[] playerList;

    // check if game state has ended
    private boolean gameEnded;

    // constructor

    public Game(Player[] playerList) {
        this.playerList = playerList;
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

    public int decideWinner() {
        // draw = 0;
        // winner p1 = 1
        // winner p2 = 2
        int winner;

        // magic numbers BAD! just for testing
        // 0 -> player1
        // 1 -> player2

        switch (this.obtainTheResultOfTheBattle()) {
            case -1:
                System.out.println(">>> Winner is " + this.playerList[1].getPlayerName() + ", with "+ this.playerList[1].currentPlayerHandName() +  "! <<<");
                winner = 2;
                break;
            case 1:
                System.out.println(">>> Winner is " + this.playerList[0].getPlayerName() + ", with "+ this.playerList[0].currentPlayerHandName() +  "! <<<");
                winner = 1;
                break;
            default:
                System.out.println("It's a draw, let's go again!\n");
                winner = 0;
        }

        return winner;
    }

    private int obtainTheResultOfTheBattle() {
        return winConditionTable[this.obtainHandFromPlayer(0)][this.obtainHandFromPlayer(1)];
    }

    private int obtainHandFromPlayer(int player) {
        System.out.println("Player [" + player + "] has: " + this.playerList[player].currentPlayerHandName());
        return this.playerList[player].getCurrentPlayerHand();
    }

    public void start(){
        for (int i = 1; i <= getNumberOfGames(); i++) {

            System.out.println(">>> Game number " + i + " <<<");
            while (!isGameEnded()) {

                // make hands for players
                this.playerList[0].setCurrentPlayerHand();
                this.playerList[1].setCurrentPlayerHand();

                // just for 2 players as of now
                int winner = decideWinner();

                // loops until it finds a winner
                if (winner != 0) {
                    setGameEnded(true);
                }

                // winner is initialized with -2, so if it's still -2 here, something went very wrong with the game logic
                if (winner == -2) {
                    System.out.println("[ERROR] Something has went very wrong... Exiting the game...");
                    return;
                }
            }

            // ensures game is still running for the next loop
            setGameEnded(false);
            System.out.println(" ");
        }
    }

}
