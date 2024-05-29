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

            switch (monsters[i]){
                case WEREWOLF:
                    this.monsterList[i] = new Werewolf();
                    break;
                case VAMPIRE:
                    this.monsterList[i] = new Vampire();
                    break;
                case MUMMY:
                    this.monsterList[i] = new Mummy();
                    break;
                default: this.monsterList[i] = null;
            }
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
        if(this.checkIfAllMonstersAreDead()) {
            return -1;
        }

        for (int i = 0; i < this.monsterList.length; i++) {
            if (this.monsterList[i] != null) {
                return i;
            }
        }
        return -1;
    }

    private void initMonsterList() {
        for (int i = 0; i < this.monsterList.length; i++) {

            this.monsterList[i] = getRandomMonster();

        }
    }

    // testing

    public void debug() {
        for (int i = 0; i < this.monsterList.length; i++) {
            System.out.println("Monster type: " + this.monsterList[i]);
        }
    }

    public void testBattle() {
        this.monsterList[0].attack(this.monsterList[1]);
        System.out.println("Monster 0: " + this.monsterList[0].toString() + " attacked " + this.monsterList[1].toString());
        System.out.println("Monster 0 health: " + this.monsterList[0].getHealth());
        System.out.println("Monster 1 health: " + this.monsterList[1].getHealth());
    }



    private Monster getRandomMonster() {
        MonsterTypeEnum randomMonstertype = MonsterTypeEnum.getRandomMonster();
        if(randomMonstertype == null) {
            System.out.println("Random monster failed.");
            return null;
        }

        switch (randomMonstertype){
            case WEREWOLF:
                return new Werewolf();
            case VAMPIRE:
                return new Vampire();
            case MUMMY:
                return new Mummy();
            default: return null;
        }
    }
}