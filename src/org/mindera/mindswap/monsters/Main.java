package org.mindera.mindswap.monsters;

public class Main {
    public static void main(String[] args) {

        int numberOfMonsters = 10;

        Player p1 = new Player("player 1", numberOfMonsters);
        Player p2 = new Player("player 2", numberOfMonsters);

        p1.debug();

        Game game = new Game(p1, p2);


    }
}
