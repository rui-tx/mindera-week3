package org.mindera.mindswap.monsters;

import org.mindera.mindswap.rockpaperscissors.Random;

public class Player {

    private String name;
    private Monster[] monsterList;
    private int currentMonsterIndex;
    private int specialMonsterChance = 5; // 1 in n

    public Player(String name, int numberOfMonsters) {
        this.name = name;
        this.monsterList = new Monster[numberOfMonsters];
        this.currentMonsterIndex = 0;

        this.initMonsterList();
    }

    public Player(String name, MonsterTypeEnum[] monsterList) {
        this.name = name;
        this.monsterList = new Monster[monsterList.length];

        this.pickMonsters(monsterList);
    }

    public String getName() {
        return name;
    }

    private void pickMonsters(MonsterTypeEnum[] monsters) {
        for (int i = 0; i < this.monsterList.length; i++) {

            switch (monsters[i]) {
                case WEREWOLF:
                    this.monsterList[i] = this.generateWerewolf();
                    break;
                case VAMPIRE:
                    this.monsterList[i] = this.generateVampire();
                    break;
                case MUMMY:
                    this.monsterList[i] = this.generateMummy();
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

    // sort player by health, this way we can pick monsters with > 0 health
    public void sortPlayerMonstersByHealth() {
        boolean noSwaps = true;

        for (int i = 0; i < this.monsterList.length - 1; i++) {
            if (this.monsterList[i].getHealth() > this.monsterList[i + 1].getHealth()) {
                noSwaps = false;
                Monster temp;
                temp = this.monsterList[i + 1];
                this.monsterList[i + 1] = this.monsterList[i];
                this.monsterList[i] = temp;
            }
        }

        if (!noSwaps) {
            this.sortPlayerMonstersByHealth();
        }
    }

    public int getRandomMonsterIndexFromHand() {
        if (this.checkIfAllMonstersAreDead()) {
            return -1;
        }

        this.sortPlayerMonstersByHealth();
        int min = -1;
        for (int i = 0; i < this.monsterList.length; i++) {
            if (!this.monsterList[i].isDead()) {
                min = i;
                break;
            }
        }

        if (min == -1) {
            return -1;
        }

        this.currentMonsterIndex = Random.getRandomNumber(min, this.monsterList.length - 1);
        return this.currentMonsterIndex;
    }

    public int checkHowManyMonstersAreAlive() {
        int monstersAlive = 0;
        for (int i = 0; i < this.monsterList.length; i++) {
            if (!this.monsterList[i].isDead()) {
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
                return this.generateWerewolf();
            case VAMPIRE:
                return this.generateVampire();
            case MUMMY:
                return this.generateMummy();
            default:
                return null;
        }
    }

    private Werewolf generateWerewolf() {
        int check = Random.getRandomNumber(1, this.specialMonsterChance);
        // generates a special type of werewolf
        if (check == this.specialMonsterChance) {
            check = Random.getRandomNumber(0, WerewolfSpecialEnum.values().length - 1);
            WerewolfSpecialEnum special = WerewolfSpecialEnum.values()[check];
            return new Werewolf(special.getHealth(), special.getAttackPower(), special.getName());
        }

        return new Werewolf();
    }

    private Vampire generateVampire() {
        int check = Random.getRandomNumber(1, this.specialMonsterChance);
        // generates a special type of vampire
        if (check == this.specialMonsterChance) {
            check = Random.getRandomNumber(0, VampireSpecialEnum.values().length - 1);
            VampireSpecialEnum special = VampireSpecialEnum.values()[check];
            return new Vampire(special.getHealth(), special.getAttackPower(), special.getName());
        }

        return new Vampire();
    }

    private Mummy generateMummy() {
        int check = Random.getRandomNumber(1, this.specialMonsterChance);
        // generates a special type of werewolf
        if (check == this.specialMonsterChance) {
            check = Random.getRandomNumber(0, MummySpecialEnum.values().length - 1);
            MummySpecialEnum special = MummySpecialEnum.values()[check];
            return new Mummy(special.getHealth(), special.getAttackPower(), special.getName());
        }

        return new Mummy();
    }

    public void printMonsters() {
        for (int i = 0; i < this.monsterList.length; i++) {
            if (this.monsterList[i] != null) {
                System.out.println("[" + i + "]: " + this.monsterList[i].toString() + " health: " + this.monsterList[i].getHealth());
            }

        }
    }
}