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

    public void attack(StrikeableInterface p1Monster, StrikeableInterface p2Monster) {

        System.out.println(this.getName() + " starts to attack both players!");
        super.attack(p1Monster);
        super.attack(p2Monster);

    }

    @Override
    public String toString() {
        if (this.getName() != null) {
            return this.getName();
        }
        return "Witch";
    }

    @Override
    public void decreaseHealth(int decreaseAmount) {
        //System.out.println("Witch decrease damage received to half!");
        //int health = this.getHealth() - decreaseAmount;
        this.setHealth(decreaseAmount / 2);

        if (this.getHealth() <= 0) {
            System.out.println("After a massive blow to the back of the head, the Witch flies away!");
            this.setHealth(0);
        }
    }

    public boolean isDead() {
        return this.getHealth() <= 0;
    }
}