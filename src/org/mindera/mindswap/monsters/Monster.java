package org.mindera.mindswap.monsters;

public abstract class Monster {

    private int health;
    private int attackPower;
    private String name;

    public Monster(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
    }

    public Monster(int health, int attackPower, String name) {
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

    @Override
    public String toString() {
        return "This is a Monster";
    }

    public void attack(Monster other) {
        other.decreaseHealth(this.attackPower);
    }

    public void increaseHealth(int increaseAmount) {
        this.health += increaseAmount;
    }

    public void decreaseHealth(int decreaseAmount) {
        this.health -= decreaseAmount;
        if (this.health <= 0) {
            this.health = 0;
        }
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}