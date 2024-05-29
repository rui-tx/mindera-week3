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

        int p1Pick = this.p1.getRandomMonsterIndexFromHand();
        System.out.println("Player 1 selects monster: " + this.p1.getMonsterList()[p1Pick].toString());
        int p2Pick = this.p2.getRandomMonsterIndexFromHand();
        System.out.println("Player 2 selects monster: " + this.p2.getMonsterList()[p2Pick].toString());

        System.out.println("Let's play!");

        while (!gameEnded) {
            System.out.println(">>> Round Begins, Let's Fight! <<<\n");

            if (Random.getRandomNumber(1, 3) == 1) {
                int newP1Pick = this.p1.getRandomMonsterIndexFromHand();
                if (newP1Pick != p1Pick) {
                    System.out.println("Player 1 decides and selects another monster: " + this.p1.getMonsterList()[newP1Pick].toString());
                }
            }

            if (Random.getRandomNumber(1, 3) == 1) {
                int newP2Pick = this.p2.getRandomMonsterIndexFromHand();
                if (newP2Pick != p2Pick) {
                    System.out.println("Player 2 decides and selects another monster: " + this.p2.getMonsterList()[newP2Pick].toString());
                }
            }

            // p1 attacks 1st
            System.out.println("> It's Player 1 turn <");


            this.p1.getMonsterList()[p1Pick].attack(this.p2.getMonsterList()[p2Pick]);
            System.out.println("P1 " + this.p1.getMonsterList()[p1Pick].toString() + " attacks P2 " + this.p2.getMonsterList()[p2Pick].toString() + " for " + this.p1.getMonsterList()[p1Pick].getAttackPower() + " points of damage!");
            System.out.println("P2 " + this.p2.getMonsterList()[p2Pick].toString() + " has now " + this.p2.getMonsterList()[p2Pick].getHealth() + " points of health.");

            if (this.p2.getMonsterList()[p2Pick].getHealth() <= 0) {
                System.out.println(">>> P2 monster is dead! <<<");
                this.p2.getMonsterList()[p2Pick] = null;
                // picks next monster
                this.p2.sortPlayerMonsters();
                p2Pick = this.p2.getRandomMonsterIndexFromHand();
                if (p2Pick == -1) {
                    System.out.println(">>> All P2 monsters are dead. <<<\n");
                    System.out.println(">>>> P1 wins! <<<<");
                    this.gameEnded = true;
                    return;
                }
                System.out.println("Player 2 new monster: " + this.p2.getMonsterList()[p2Pick].toString());
            }

            // p2 attacks 2nd
            System.out.println("\nPlayer 2 turn");

            this.p2.getMonsterList()[p2Pick].attack(this.p1.getMonsterList()[p1Pick]);
            System.out.println("P2 " + this.p2.getMonsterList()[p2Pick].toString() + " attacks P1 " + this.p1.getMonsterList()[p1Pick].toString() + " for " + this.p2.getMonsterList()[p2Pick].getAttackPower() + " points of damage!");
            System.out.println("P1 " + this.p1.getMonsterList()[p1Pick].toString() + " has now " + this.p1.getMonsterList()[p1Pick].getHealth() + " points of health.");

            if (this.p1.getMonsterList()[p1Pick].getHealth() <= 0) {
                System.out.println(">>> P1 monster is dead! <<<");
                this.p1.getMonsterList()[p1Pick] = null;
                // picks next monster
                this.p1.sortPlayerMonsters();
                p1Pick = this.p1.getRandomMonsterIndexFromHand();
                if (p1Pick == -1) {
                    System.out.println(">>> All P1 monsters are dead. <<<\n");
                    System.out.println(">>>> P2 wins! <<<<");
                    this.gameEnded = true;
                    return;
                }
                System.out.println("Player 1 new monster: " + this.p1.getMonsterList()[p1Pick].toString());
            }


            if (this.p1.checkIfAllMonstersAreDead()) {
                System.out.println(">>> All P1 monsters are dead. <<<\n");
                System.out.println(">>>> P2 wins! <<<<");
                this.gameEnded = true;
                return;
            }

            if (this.p2.checkIfAllMonstersAreDead()) {
                System.out.println(">>> All P2 monsters are dead. <<<\n");
                System.out.println(">>>> P1 wins! <<<<");
                this.gameEnded = true;
                return;
            }

            if (gameEnded) {
                return;
            }

            System.out.println("\n>>> End of round status <<<");
            System.out.println("Player 1 current monster: " + this.p1.getMonsterList()[p1Pick].toString() + " health: " + this.p1.getMonsterList()[p1Pick].getHealth());
            System.out.println("P1 List:");
            this.p1.printMonsters();
            System.out.println("\nPlayer 2 current monster: " + this.p2.getMonsterList()[p2Pick].toString() + " health: " + this.p2.getMonsterList()[p2Pick].getHealth());
            System.out.println("P2 List:");
            this.p2.printMonsters();
            System.out.println("\n>>> End of Round <<<\n");
        }
    }
}
