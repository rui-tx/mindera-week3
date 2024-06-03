package org.mindera.mindswap.monstersinterfaces.strikeable.monsters;

// names from https://perchance.org/boss-titles, https://www.fantasynamegenerators.com/werewolf-names.php
public enum VampireSpecialEnum {
    EDWARD(20, 20, "Edward of the Thousand Suns"),
    DRACULA(25, 20, "Lord Dracula, Drinker of Blood and Souls"),
    MOSKI(5, 25, "Moski, the friendly Mosquito");

    private final int health;
    private final int attackPower;
    private final String name;

    VampireSpecialEnum(int health, int attackPower, String name) {
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
