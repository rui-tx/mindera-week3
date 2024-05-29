package org.mindera.mindswap.monsters;

import org.mindera.mindswap.rockpaperscissors.Random;

public class Game {

    private Player p1;
    private Player p2;
    private boolean gameEnded;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void play() {

        int p1Pick = this.p1.getNextMonsterFromHand();
        int p2Pick = this.p2.getNextMonsterFromHand();

        while(!gameEnded) {
            System.out.println("\n Round Begins \n");


            //int randomP1Pick = Random.getRandomNumber(0, p1.getMonsterList().length - 1);
            //int randomP2Pick = Random.getRandomNumber(0, p2.getMonsterList().length - 1);

            // p1 attacks 1st
            System.out.println("Player 1 turn");
            this.p1.getMonsterList()[p1Pick].attack(this.p2.getMonsterList()[p2Pick]);
            System.out.println("P1 " + this.p1.getMonsterList()[p1Pick].toString() + " attacks " + this.p2.getMonsterList()[p2Pick].toString());
            System.out.println("P2 " + this.p2.getMonsterList()[p2Pick].toString() + " has " + this.p2.getMonsterList()[p2Pick].getHealth());

            if (this.p2.getMonsterList()[p2Pick].getHealth() <= 0) {
                System.out.println(">>> P2 monster is dead! <<<");
                this.p2.getMonsterList()[p2Pick] = null;
                // picks next monster
                p2Pick = this.p2.getNextMonsterFromHand();
                if (p2Pick == -1) {
                    System.out.println(">>> All P2 monsters are dead. <<<");
                    System.out.println("P1 wins!");
                    this.gameEnded = true;
                    return;
                }
            }

            // p2 attacks 2nd
            System.out.println("\nPlayer 2 turn");

            this.p2.getMonsterList()[p2Pick].attack(this.p1.getMonsterList()[p1Pick]);
            System.out.println("P2 " + this.p2.getMonsterList()[p2Pick].toString() + " attacks " + this.p1.getMonsterList()[p1Pick].toString());
            System.out.println("P1 " + this.p1.getMonsterList()[p1Pick].toString() + " has " + this.p1.getMonsterList()[p1Pick].getHealth());

            if (this.p1.getMonsterList()[p1Pick].getHealth() <= 0) {
                System.out.println(">>> P1 monster is dead! <<<");
                this.p1.getMonsterList()[p1Pick] = null;
                // picks next monster
                p1Pick = this.p1.getNextMonsterFromHand();
                if (p1Pick == -1) {
                    System.out.println(">>> All P1 monsters are dead. <<<");
                    System.out.println("P2 wins!");
                    this.gameEnded = true;
                    return;
                }
            }


            if(this.p1.checkIfAllMonstersAreDead()){
                System.out.println(">>> All P1 monsters are dead. <<<");
                System.out.println("P2 wins!");
                this.gameEnded = true;
                return;
            }

            if(this.p2.checkIfAllMonstersAreDead()){
                System.out.println(">>> All P2 monsters are dead. <<<");
                System.out.println("P1 wins!");
                this.gameEnded = true;
                return;
            }

            if (gameEnded) {
                return;
            }

            System.out.println("---");
        }
    }
}
