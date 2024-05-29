package org.mindera.mindswap.monsters;

public abstract class Monster {

    private MonsterTypeEnum type;
    private int health;
    private int attackPower;

    public Monster(MonsterTypeEnum type) {
        this.health = type.getHealth();
        this.attackPower = type.getAttackPower();
    }

    @Override
    public String toString() {
        return "This is a Monster of type: " + this.type.toString();
    }
}