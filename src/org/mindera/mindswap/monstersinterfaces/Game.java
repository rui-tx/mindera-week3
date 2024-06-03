package org.mindera.mindswap.monstersinterfaces;

import org.mindera.mindswap.monstersinterfaces.fairies.Fairy;
import org.mindera.mindswap.monstersinterfaces.fairies.FairySpecialEnum;
import org.mindera.mindswap.monstersinterfaces.strikeable.Witch;
import org.mindera.mindswap.monstersinterfaces.strikeable.WitchSpecialEnum;
import org.mindera.mindswap.rockpaperscissors.Random;

public class Game {

    private final double miniBossChange = 0.1;
    private Player[] players;
    private int currentPlayer;
    private boolean gameEnded;
    private Supernatural miniBoss;

    public Game(Player p1, Player p2) {
        this.players = new Player[2];
        this.players[0] = p1;
        this.players[1] = p2;
        this.currentPlayer = 0;
    }

    public void play() {

        while (!gameEnded) {
            this.gameTurn();
            this.playersTurn();
        }
        this.printGameStatus();
    }

    private void gameTurn() {
        if (this.miniBoss == null) {
            double miniBossChance = Math.random();
            if (miniBossChance <= this.miniBossChange) {
                this.currentPlayer = 2;
                System.out.println("\n>>> A new mini boss appears! <<<\n");
                // TODO: fix the bug where sometimes it print 2 times the winner
                boolean check = this.miniBossBattle();
                if (!check) {
                    return;
                }
                System.out.println("\n>>> Mini Boss Battle Over! <<<\n");
                this.currentPlayer = 0;
            }
        }
    }

    private void playersTurn() {
        Player p1 = this.players[0];
        Player p2 = this.players[1];

        if (this.currentPlayer == 0) {
            int p1Pick = p1.getRandomMonsterIndexFromHand();
            // maybe redundant
            if (!this.canCurrentPlayerMonsterPlay(p1) && p1Pick == -1) {
                this.gameWon(p2);
                return;
            }

            System.out.println("\n" + p1.getName() + "'s turn");
            if (!this.canCurrentPlayerMonsterPlay(p2)) {
                this.gameWon(p1);
                return;
            }

            p1.getMonsterList()[p1.getCurrentMonsterIndex()].attack(
                    p2.getMonsterList()[p2.getCurrentMonsterIndex()]);

            this.currentPlayer = 1;
        } else {
            int p2Pick = p2.getRandomMonsterIndexFromHand();
            if (!this.canCurrentPlayerMonsterPlay(p2) && p2Pick == -1) {
                this.gameWon(p1);
                return;
            }

            System.out.println("\n" + p2.getName() + "'s turn");
            if (!this.canCurrentPlayerMonsterPlay(p1)) {
                this.gameWon(p2);
                return;
            }

            p2.getMonsterList()[p2.getCurrentMonsterIndex()].attack(
                    p1.getMonsterList()[p1.getCurrentMonsterIndex()]);
            this.currentPlayer = 0;
        }
    }

    private boolean canCurrentPlayerMonsterPlay(Player player) {
        if (player.isCurrentMonsterDead()) {
            int playerPick = player.getRandomMonsterIndexFromHand();
            if (playerPick == -1) {
                System.out.println(player.getName() + " is out of cards!");
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean playersAttackMiniBoss() {
        Player p1 = this.players[0];
        Player p2 = this.players[1];

        if (this.miniBoss instanceof Witch) {

            if (!this.canCurrentPlayerMonsterPlay(p1)) {
                this.gameWon(p2);
                return true;
            }

            p1.getMonsterList()[p1.getCurrentMonsterIndex()].attack((Witch) miniBoss);
            if (((Witch) (this).miniBoss).isDead()) {
                return true;
            }

            if (!this.canCurrentPlayerMonsterPlay(p2)) {
                this.gameWon(p1);
                return true;
            }

            p2.getMonsterList()[p2.getCurrentMonsterIndex()].attack((Witch) miniBoss);
            return ((Witch) (this).miniBoss).isDead();
        }

        return false;
    }

    private boolean miniBossBattle() {
        Player p1 = this.players[0];
        Player p2 = this.players[1];

        this.setMiniBoss();

        if (this.miniBoss instanceof Fairy) {
            ((Fairy) (this).miniBoss).attack(
                    p1.getMonsterList()[p1.getCurrentMonsterIndex()],
                    p2.getMonsterList()[p2.getCurrentMonsterIndex()]);
            System.out.println(this.miniBoss.getName() + " whooshes away cackling like a mad hyena!");
            this.miniBoss = null;
            return true;
        }

        while (true) {
            if (this.miniBoss != null) {
                if (this.miniBoss instanceof Witch) {

                    if (!this.canCurrentPlayerMonsterPlay(p1)) {
                        this.gameWon(p2);
                        return false;
                    }

                    if (!this.canCurrentPlayerMonsterPlay(p2)) {
                        this.gameWon(p1);
                        return false;
                    }

                    ((Witch) miniBoss).attack(
                            p1.getMonsterList()[p1.getCurrentMonsterIndex()],
                            p2.getMonsterList()[p2.getCurrentMonsterIndex()]);

                    // returns true if miniboss is dead;
                    if (this.playersAttackMiniBoss()) {
                        return true;
                    }
                }
            }
        }
    }

    private void setMiniBoss() {
        double miniBossChance = Math.random();
        if (miniBossChance <= 0.5) {
            int randomFairy = Random.getRandomNumber(0, FairySpecialEnum.values().length - 1);
            FairySpecialEnum fairy = FairySpecialEnum.values()[randomFairy];
            this.miniBoss = new Fairy(fairy.getAttackPower(), fairy.getName());
        } else {
            int randomWitch = Random.getRandomNumber(0, WitchSpecialEnum.values().length - 1);
            WitchSpecialEnum witch = WitchSpecialEnum.values()[randomWitch];
            this.miniBoss = new Witch(witch.getHealth(), witch.getAttackPower(), witch.getName());
        }
    }

    private void gameWon(Player player) {
        this.gameEnded = true;
        System.out.printf("\n>>>> %s wins! <<<<\n", player.getName());
    }

    private void printGameStatus() {
        System.out.println("\n>>> Game status <<<");
        System.out.println(this.players[0].getName() + " List:");
        this.players[0].printMonsters();
        System.out.println(this.players[1].getName() + " List:");
        this.players[1].printMonsters();
        System.out.println("\n>>> --- <<<\n");
    }

    /*

    private void makeMiniBoss() {

        if (this.miniBoss == null) {
            System.out.println(">>> A new mini boss appears! <<<\n");

            double check = Math.random();
            if (check <= 0.5) {
                this.miniBoss = new Fairy(WEREWOLF.getAttackPower(), "Tinkerbell");
                ((Fairy) miniBoss).attack(p1.getMonsterList()[0], p2.getMonsterList()[0]);
                System.out.println("The fairy wooshes away giggling like a mad hyena!\n");
                this.miniBoss = null;
                return;
            }

            this.miniBoss = new Witch(WEREWOLF.getHealth(), WEREWOLF.getAttackPower(), "The Witch From the Wilds");
        }

        //((Witch) miniBoss).attack(p1.getMonsterList()[0], p2.getMonsterList()[0]);
    }

    public void play() {
        System.out.println(">>> It's Monster Battle Time! Fight! <<<\n");
        while (!gameEnded) {

            if (this.miniBoss == null) {
                double miniBossChance = Math.random();
                if (miniBossChance <= 0.2) {
                    this.makeMiniBoss();
                }
            }

            if (miniBoss != null) {
                if (((Witch) (this).miniBoss).getHealth() <= 0) {
                    this.miniBoss = null;
                    continue;
                }

                ((Witch) miniBoss).attack(
                        p1.getMonsterList()[this.p1.getCurrentMonsterIndex()],
                        p2.getMonsterList()[this.p2.getCurrentMonsterIndex()]);
            }

            // p1 turns
            this.p1Attacks();
            if (gameEnded) {
                return;
            }

            if (miniBoss != null) {
                if (((Witch) (this).miniBoss).getHealth() <= 0) {
                    this.miniBoss = null;
                    continue;
                }

                ((Witch) miniBoss).attack(
                        p1.getMonsterList()[this.p1.getCurrentMonsterIndex()],
                        p2.getMonsterList()[this.p2.getCurrentMonsterIndex()]);
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

        if (this.miniBoss != null) {
            System.out.printf("%s attacks with [%s] %s (HP: %s AP: %s), mini boss %s defends (HP: %s AP: %s)\n",
                    this.p1.getName(), p1Pick, this.p1.getMonsterList()[p1Pick], this.p1.getMonsterList()[p1Pick].getHealth(), this.p1.getMonsterList()[p1Pick].getAttackPower(),
                    this.miniBoss.getName(), ((Witch) (this).miniBoss).getHealth(), (this).miniBoss.getAttackPower());

            this.p1.getMonsterList()[p1Pick].attack((Witch) (this).miniBoss);
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
        int p2Pick = this.p2.getRandomMonsterIndexFromHand();
        if (p2Pick == -1) {
            this.gameWon(p1);
            this.gameEnded = true;
            return;
        }

        if (this.miniBoss != null) {
            System.out.printf("%s attacks with [%s] %s (HP: %s AP: %s), mini boss %s defends (HP: %s AP: %s)\n",
                    this.p2.getName(), p2Pick, this.p2.getMonsterList()[p2Pick], this.p2.getMonsterList()[p2Pick].getHealth(), this.p2.getMonsterList()[p2Pick].getAttackPower(),
                    this.miniBoss.getName(), ((Witch) (this).miniBoss).getHealth(), (this).miniBoss.getAttackPower());

            this.p2.getMonsterList()[p2Pick].attack((Witch) (this).miniBoss);

            return;
        }

        int p1Pick = this.p1.getRandomMonsterIndexFromHand();
        if (p1Pick == -1) {
            this.gameWon(p2);
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

     */
}