package org.mindera.mindswap.monsters;

import org.mindera.mindswap.rockpaperscissors.Random;

public enum MonsterTypeEnum {
    WEREWOLF(10, 2),
    VAMPIRE(10, 2),
    MUMMY(10, 2);

    private final int health;
    private final int attackPower;

    MonsterTypeEnum(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public static MonsterTypeEnum getRandomMonster() {
        int random = Random.getRandomNumber(0, MonsterTypeEnum.values().length - 1);
        switch (random) {
            case 0:
                return WEREWOLF;
            case 1:
                return VAMPIRE;
            case 2:
                return MUMMY;
        }
        return null;
    }
}