package org.mindera.mindswap.monsters;

import org.mindera.mindswap.rockpaperscissors.Random;

public class Player {

    private String name;
    private Monster[] monsterList;

    public Player(String name, int numberOfMonsters) {
        this.name = name;
        this.monsterList = new Monster[numberOfMonsters];

        this.initMonsterList();
    }

    public Player(String name, MonsterTypeEnum[] monsterList) {
        this.name = name;
        this.monsterList = new Monster[monsterList.length];

        this.pickMonsters(monsterList);
    }

    private void pickMonsters(MonsterTypeEnum[] monsters) {
        for (int i = 0; i < this.monsterList.length; i++) {

            switch (monsters[i]) {
                case WEREWOLF:
                    this.monsterList[i] = new Werewolf();
                    break;
                case VAMPIRE:
                    this.monsterList[i] = new Vampire();
                    break;
                case MUMMY:
                    this.monsterList[i] = new Mummy();
                    break;
                default:
                    this.monsterList[i] = null;
            }
        }

    }

    private void initMonsterList() {
        for (int i = 0; i < this.monsterList.length; i++) {
            this.monsterList[i] = getRandomMonster();
        }
    }

    public Monster[] getMonsterList() {
        return monsterList;
    }

    public boolean checkIfAllMonstersAreDead() {
        for (int i = 0; i < this.monsterList.length; i++) {
            if (this.monsterList[i] != null) {
                return false;
            }
        }
        return true;
    }

    public int getNextMonsterFromHand() {
        if (this.checkIfAllMonstersAreDead()) {
            return -1;
        }

        for (int i = 0; i < this.monsterList.length; i++) {
            if (this.monsterList[i] != null) {
                return i;
            }
        }
        return -1;
    }

    // because we have nulls, we sort the player hand after each monster dies
    // this way we can randomize the pick and make sure the pick is not null
    public void sortPlayerMonsters() {
        if (this.checkIfAllMonstersAreDead()) {
            return;
        }

        Monster[] sortedMonsterArray = new Monster[this.monsterList.length];

        int checkAlive = -1;
        for (int i = 0; i < this.checkHowManyMonstersAreAlive(); i++) {
            if (this.monsterList[i] != null) {
                checkAlive++;
                sortedMonsterArray[checkAlive] = this.monsterList[i];
            }
        }

        this.monsterList = sortedMonsterArray;
    }


    // because we have null index we need to sort
    public int getRandomMonsterIndexFromHand() {
        if (this.checkIfAllMonstersAreDead()) {
            return -1;
        }

        return Random.getRandomNumber(0, this.checkHowManyMonstersAreAlive() - 1);
    }

    public int checkHowManyMonstersAreAlive() {
        int monstersAlive = 0;
        for (int i = 0; i < this.monsterList.length; i++) {
            if (this.monsterList[i] != null) {
                monstersAlive++;
            }
        }
        return monstersAlive;
    }

    private Monster getRandomMonster() {
        MonsterTypeEnum randomMonstertype = MonsterTypeEnum.getRandomMonster();
        if (randomMonstertype == null) {
            System.out.println("Random monster failed.");
            return null;
        }

        switch (randomMonstertype) {
            case WEREWOLF:
                return new Werewolf();
            case VAMPIRE:
                return new Vampire();
            case MUMMY:
                return new Mummy();
            default:
                return null;
        }
    }

    public void printMonsters() {
        for (int i = 0; i < this.monsterList.length; i++) {
            if (this.monsterList[i] != null) {
                System.out.println("[" + i + "]: " + this.monsterList[i].toString() + " health: " + this.monsterList[i].getHealth());
            }

        }
    }
}