package org.mindera.mindswap.monstersinterfaces.strikeable.monsters;

public enum WerewolfSpecialEnum {
    JAKE(50, 10, "Jake 'No Shirt' Muscles"),
    ROOFIE(40, 30, "Roofie Devour of Hearts"),
    MINI(30, 20, "Queen Mini, The Lord of the Seven Seas");

    private final int health;
    private final int attackPower;
    private final String name;

    WerewolfSpecialEnum(int health, int attackPower, String name) {
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
