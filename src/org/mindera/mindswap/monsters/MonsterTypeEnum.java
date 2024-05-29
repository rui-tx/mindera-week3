package org.mindera.mindswap.monsters;

import org.mindera.mindswap.rockpaperscissors.Random;

public enum MonsterTypeEnum {
    WEREWOLF(25, 3),
    VAMPIRE(10, 10),
    MUMMY(20, 8);

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
        return switch (random) {
            case 0 -> WEREWOLF;
            case 1 -> VAMPIRE;
            case 2 -> MUMMY;
            default -> null;
        };
    }
}