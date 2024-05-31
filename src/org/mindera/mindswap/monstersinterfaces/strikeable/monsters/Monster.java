package org.mindera.mindswap.monstersinterfaces.strikeable.monsters;

import org.mindera.mindswap.monstersinterfaces.Supernatural;
import org.mindera.mindswap.monstersinterfaces.strikeable.StrikeableInterface;


public abstract class Monster extends Supernatural implements StrikeableInterface {

    public Monster(int health, int attackPower) {
        super(health, attackPower);
    }

    public Monster(int health, int attackPower, String name) {
        super(health, attackPower, name);
    }

    @Override
    public String toString() {
        return "This is a Monster";
    }

    public void decreaseHealth(int decreaseAmount) {
        int health = this.getHealth() - decreaseAmount;
        this.setHealth(health);
        if (this.getHealth() <= 0) {
            this.setHealth(0);
        }
    }
}