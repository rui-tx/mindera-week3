package org.mindera.mindswap.monsters;

public class Game {

    private Player p1;
    private Player p2;
    private boolean gameEnded;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void play() {
        while (!gameEnded) {

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

            this.printRoundStatus();
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

        System.out.printf("%s attacks with %s, %s defends with %s\n",
                this.p1.getName(), this.p1.getMonsterList()[p1Pick], this.p2.getName(), this.p2.getMonsterList()[p2Pick]);
        this.p1.getMonsterList()[p1Pick].attack(this.p2.getMonsterList()[p2Pick]);

        if (this.p2.getMonsterList()[p2Pick].isDead()) {
            System.out.printf("%s %s's is dead!\n", this.p2.getName(), this.p2.getMonsterList()[p2Pick]);
            // picks next monster
            p2Pick = this.p2.getRandomMonsterIndexFromHand();
            if (p2Pick == -1) {
                System.out.printf("%s monster are all dead!\n", this.p2.getName());
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

        System.out.printf("%s attacks with %s, %s defends with %s\n",
                this.p2.getName(), this.p2.getMonsterList()[p2Pick], this.p1.getName(), this.p1.getMonsterList()[p1Pick]);
        this.p2.getMonsterList()[p2Pick].attack(this.p1.getMonsterList()[p1Pick]);

        if (this.p1.getMonsterList()[p1Pick].isDead()) {
            System.out.printf("%s %s's is dead!\n", this.p1.getName(), this.p1.getMonsterList()[p2Pick]);
            // picks next monster
            p1Pick = this.p1.getRandomMonsterIndexFromHand();
            if (p1Pick == -1) {
                System.out.printf("%s monster are all dead!\n", this.p1.getName());
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