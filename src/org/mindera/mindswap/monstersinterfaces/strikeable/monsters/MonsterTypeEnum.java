package org.mindera.mindswap.monstersinterfaces.strikeable.monsters;

import org.mindera.mindswap.rockpaperscissors.Random;

public enum MonsterTypeEnum {
    WEREWOLF(25, 12),
    VAMPIRE(20, 10),
    MUMMY(30, 12);

    private final int health;
    private final int attackPower;

    MonsterTypeEnum(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
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

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }
}