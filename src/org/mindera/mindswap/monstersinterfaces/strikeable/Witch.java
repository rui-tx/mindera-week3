package org.mindera.mindswap.monstersinterfaces.strikeable;

import org.mindera.mindswap.monstersinterfaces.Supernatural;

public class Witch extends Supernatural implements StrikeableInterface {

    private int health;

    public Witch(int health, int attackPower) {
        super(attackPower);
        this.health = health;
    }

    public Witch(int health, int attackPower, String name) {
        super(attackPower, name);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void decreaseHealth(int decreaseAmount) {
        int health = this.getHealth() - (decreaseAmount / 2);
        this.setHealth(health);
        if (this.getHealth() <= 0) {
            this.health = 0;
        }
    }

    public boolean isDead() {
        return this.getHealth() <= 0;
    }
}