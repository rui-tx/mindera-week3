package org.mindera.mindswap.monstersinterfaces.strikeable.monsters;

import org.mindera.mindswap.monstersinterfaces.Supernatural;
import org.mindera.mindswap.monstersinterfaces.strikeable.StrikeableInterface;


public abstract class Monster extends Supernatural implements StrikeableInterface {

    private int health;

    public Monster(int health, int attackPower) {
        super(attackPower);
        this.health = health;
    }

    public Monster(int health, int attackPower, String name) {
        super(attackPower, name);
        this.health = health;
    }

    @Override
    public String toString() {
        return "This is a Monster";
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (this.getHealth() < 0) {
            this.health = 0;
        }
    }

    public boolean isDead() {
        return this.getHealth() <= 0;
    }

    public void decreaseHealth(int decreaseAmount) {
        //int health = this.getHealth() - decreaseAmount;

        this.setHealth(decreaseAmount);
        if (this.getHealth() <= 0) {
            this.setHealth(0);
        }
    }
}