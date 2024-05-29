package org.mindera.mindswap.monsters;

public class Main {
    public static void main(String[] args) {

        int numberOfMonsters = 2;

        Player p1 = new Player("player 1", numberOfMonsters);
        Player p2 = new Player("player 2", numberOfMonsters);

        for (int i = 0; i < 6; i++) {
            p1.testBattle();
            System.out.println();
        }


        Game game = new Game(p1, p2);


    }
}
