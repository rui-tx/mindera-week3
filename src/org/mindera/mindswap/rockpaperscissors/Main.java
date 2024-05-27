package org.mindera.mindswap.rockpaperscissors;

public class Main {

    public static void main(String[] args) {

        // right now it's only for 2 players
        Player[] playerList = {
                new Player("Player 1"),
                new Player("Player 2")
        };
        Game game = new Game(playerList);


        game.start();
    }

}
