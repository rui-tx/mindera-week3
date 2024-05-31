package org.mindera.mindswap.monstersinterfaces;

import org.mindera.mindswap.monstersinterfaces.fairies.Fairy;
import org.mindera.mindswap.monstersinterfaces.strikeable.StrikeableInterface;
import org.mindera.mindswap.monstersinterfaces.strikeable.Witch;

public abstract class Supernatural {

    private int health;
    private int attackPower;
    private String name;

    public Supernatural(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
    }

    public Supernatural(int health, int attackPower, String name) {
        this.health = health;
        this.attackPower = attackPower;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }

    public boolean isDead() {
        return this.getHealth() <= 0;
    }

    public void attack(Supernatural other) {
        if (other instanceof StrikeableInterface) {
            other.decreaseHealth(this.getAttackPower());
            return;
        }

        System.out.println(other.getName() + " is not strikeable!");
    }

    public void attack(Supernatural p1Monster, Supernatural p2Monster) {
        if (this instanceof Fairy || this instanceof Witch) {
            System.out.println(this.getName() + " attacks both player monsters!");
            p1Monster.decreaseHealth(this.getAttackPower());
            p2Monster.decreaseHealth(this.getAttackPower());
            return;
        }

        System.out.println(this.getName() + " can only attack 1 monster at a time!");
    }

    public void increaseHealth(int increaseAmount) {
        int health = this.getHealth() + increaseAmount;
        this.setHealth(health);
    }

    public void decreaseHealth(int decreaseAmount) {
        int health = this.getHealth() - decreaseAmount;
        this.setHealth(health);
        if (this.getHealth() <= 0) {
            this.setHealth(0);
        }
    }
}