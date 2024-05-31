package org.mindera.mindswap.monstersinterfaces;

import org.mindera.mindswap.monstersinterfaces.fairies.Fairy;
import org.mindera.mindswap.monstersinterfaces.strikeable.Witch;
import org.mindera.mindswap.monstersinterfaces.strikeable.monsters.Vampire;

import static org.mindera.mindswap.monstersinterfaces.strikeable.monsters.MonsterTypeEnum.WEREWOLF;

public class Game {

    private Player p1;
    private Player p2;
    private boolean gameEnded;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    private void makeObstacle() {
        Vampire test = new Vampire(WEREWOLF.getHealth(), WEREWOLF.getAttackPower(), "test");
        Fairy testFairy = new Fairy(WEREWOLF.getHealth(), WEREWOLF.getAttackPower(), "Fairy");
        Witch testWitch = new Witch(WEREWOLF.getHealth(), WEREWOLF.getAttackPower(), "Witch");

        testFairy.attack(p1.getMonsterList()[0], p2.getMonsterList()[0]);
        
        System.out.println("\n\n\n\n");
    }

    public void play() {
        System.out.println(">>> It's Monster Battle Time! Fight! <<<\n");
        while (!gameEnded) {

            makeObstacle();


            // p1 turns
            this.p1Attacks();
            if (gameEnded) {
                return;
            }

            // p2 turns
            this.p2Attacks();
            if (gameEnded) {
                return;
            }

            int check = this.checkIfPlayerMonstersAreDead();
            if (gameEnded || check != 0) {
                return;
            }

            //this.printRoundStatus();
        }
    }

    private void p1Attacks() {
        int p1Pick = this.p1.getRandomMonsterIndexFromHand();
        if (p1Pick == -1) {
            this.gameWon(p2);
            this.gameEnded = true;
            return;
        }

        int p2Pick = this.p2.getRandomMonsterIndexFromHand();
        if (p2Pick == -1) {
            this.gameWon(p1);
            this.gameEnded = true;
            return;
        }

        System.out.printf("%s turns\n", this.p1.getName());
        System.out.printf("%s attacks with [%s] %s (HP: %s AP: %s), %s defends with [%s] %s (HP: %s AP: %s)\n",
                this.p1.getName(), p1Pick, this.p1.getMonsterList()[p1Pick], this.p1.getMonsterList()[p1Pick].getHealth(), this.p1.getMonsterList()[p1Pick].getAttackPower(),
                this.p2.getName(), p2Pick, this.p2.getMonsterList()[p2Pick], this.p2.getMonsterList()[p2Pick].getHealth(), this.p2.getMonsterList()[p2Pick].getAttackPower());

        this.p1.getMonsterList()[p1Pick].attack(this.p2.getMonsterList()[p2Pick]);

        System.out.println("Results");
        System.out.printf("[%s] %s (HP: %s AP: %s) \n",
                p1Pick, this.p1.getMonsterList()[p1Pick], this.p1.getMonsterList()[p1Pick].getHealth(), this.p1.getMonsterList()[p1Pick].getAttackPower());
        System.out.printf("[%s] %s (HP: %s AP: %s) \n\n",
                p2Pick, this.p2.getMonsterList()[p2Pick], this.p2.getMonsterList()[p2Pick].getHealth(), this.p2.getMonsterList()[p2Pick].getAttackPower());

        if (this.p2.getMonsterList()[p2Pick].isDead()) {
            System.out.printf("%s's %s is dead!\n\n", this.p2.getName(), this.p2.getMonsterList()[p2Pick]);
            // picks next monster
            p2Pick = this.p2.getRandomMonsterIndexFromHand();
            if (p2Pick == -1) {
                System.out.printf("%s monsters are all dead!\n", this.p2.getName());
                this.gameWon(p1);
                this.gameEnded = true;
            }
        }
    }

    private void p2Attacks() {
        int p1Pick = this.p1.getRandomMonsterIndexFromHand();
        if (p1Pick == -1) {
            this.gameWon(p2);
            this.gameEnded = true;
            return;
        }

        int p2Pick = this.p2.getRandomMonsterIndexFromHand();
        if (p2Pick == -1) {
            this.gameWon(p1);
            this.gameEnded = true;
            return;
        }

        System.out.printf("%s turns\n", this.p2.getName());
        System.out.printf("%s attacks with [%s] %s (HP: %s AP: %s), %s defends with [%s] %s (HP: %s AP: %s)\n",
                this.p2.getName(), p2Pick, this.p2.getMonsterList()[p2Pick], this.p2.getMonsterList()[p2Pick].getHealth(), this.p2.getMonsterList()[p2Pick].getAttackPower(),
                this.p1.getName(), p1Pick, this.p1.getMonsterList()[p1Pick], this.p1.getMonsterList()[p1Pick].getHealth(), this.p1.getMonsterList()[p1Pick].getAttackPower());

        this.p2.getMonsterList()[p2Pick].attack(this.p1.getMonsterList()[p1Pick]);

        System.out.println("Results");
        System.out.printf("[%s] %s (HP: %s AP: %s) \n", p2Pick, this.p2.getMonsterList()[p2Pick], this.p2.getMonsterList()[p2Pick].getHealth(), this.p2.getMonsterList()[p2Pick].getAttackPower());
        System.out.printf("[%s] %s (HP: %s AP: %s) \n\n", p1Pick, this.p1.getMonsterList()[p1Pick], this.p1.getMonsterList()[p1Pick].getHealth(), this.p1.getMonsterList()[p1Pick].getAttackPower());

        if (this.p1.getMonsterList()[p1Pick].isDead()) {
            System.out.printf("%s's %s is dead!\n\n", this.p1.getName(), this.p1.getMonsterList()[p1Pick]);
            // picks next monster
            p1Pick = this.p1.getRandomMonsterIndexFromHand();
            if (p1Pick == -1) {
                System.out.printf("%s monsters are all dead!\n", this.p1.getName());
                this.gameWon(p2);
                this.gameEnded = true;
            }
        }
    }

    private void gameWon(Player player) {
        System.out.printf(">>>> %s wins! <<<<\n", player.getName());
        this.printRoundStatus();
    }

    private int checkIfPlayerMonstersAreDead() {
        if (this.p1.checkIfAllMonstersAreDead()) {
            System.out.printf("%s monster are all dead!\n", this.p1.getName());
            System.out.printf(">>>> %s wins! <<<<\n", this.p2.getName());
            this.gameEnded = true;
            this.printRoundStatus();
            return 1;
        }

        if (this.p2.checkIfAllMonstersAreDead()) {
            System.out.printf("%s monster are all dead!\n", this.p2.getName());
            System.out.printf(">>>> %s wins! <<<<\n", this.p1.getName());
            this.printRoundStatus();
            this.gameEnded = true;
            return 2;
        }

        return 0;
    }

    private void printRoundStatus() {
        System.out.println("\n>>> Round status <<<");
        System.out.println(this.p1.getName() + " List:");
        this.p1.printMonsters();
        System.out.println(this.p2.getName() + " List:");
        this.p2.printMonsters();
        System.out.println("\n>>> --- <<<\n");
    }
}