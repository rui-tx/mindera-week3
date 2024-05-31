package org.mindera.mindswap.monstersinterfaces.strikeable;

import org.mindera.mindswap.monstersinterfaces.Supernatural;

public class Witch extends Supernatural implements StrikeableInterface {
    public Witch(int health, int attackPower) {
        super(health, attackPower);
    }

    public Witch(int health, int attackPower, String name) {
        super(health, attackPower, name);
    }

    @Override
    public void decreaseHealth(int decreaseAmount) {
        int health = this.getHealth() - (decreaseAmount / 2);
        this.setHealth(health);
        if (this.getHealth() <= 0) {
            this.setHealth(0);
        }
    }
}