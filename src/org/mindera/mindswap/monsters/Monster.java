package org.mindera.mindswap.monsters;

public abstract class Monster {

    private MonsterTypeEnum type;
    private int health;
    private int attackPower;

    public Monster(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public String toString() {
        return "This is a Monster of type: " + this.type.toString();
    }

    public void attack(Monster other) {
        other.decreaseHealth(this.attackPower);
    }

    public void increaseHealth(int increaseAmount) {
        this.health += increaseAmount;
    }

    public void decreaseHealth(int decreaseAmount) {
        this.health -= decreaseAmount;
    }
}