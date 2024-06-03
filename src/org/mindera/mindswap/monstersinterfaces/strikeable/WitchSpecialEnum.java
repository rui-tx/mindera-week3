package org.mindera.mindswap.monstersinterfaces.strikeable;

public enum WitchSpecialEnum {
    WITCH(20, 15, "Flemeth, Witch of the Wild"),
    BABA(15, 20, "Baba Yaga"),
    CIRCE(30, 10, "Circe, Daughter of the Sun God");

    private final int health;
    private final int attackPower;
    private final String name;

    WitchSpecialEnum(int health, int attackPower, String name) {
        this.health = health;
        this.attackPower = attackPower;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }
}
