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
        if (this.getName() != null) {
            return this.getName();
        }
        return "Monster";
    }

    @Override
    public void attack(StrikeableInterface other) {
        System.out.printf("%s (HP: %s AP: %s) attacks %s (HP: %s AP: %s)\n",
                this, this.getHealth(), this.getAttackPower(),
                other, other.getHealth(), other.getAttackPower());
        super.attack(other);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (this.getHealth() < 0) {
            System.out.println(this + " is dead!");
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