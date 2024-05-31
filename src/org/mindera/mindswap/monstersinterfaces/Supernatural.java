package org.mindera.mindswap.monstersinterfaces;

import org.mindera.mindswap.monstersinterfaces.strikeable.StrikeableInterface;

public abstract class Supernatural {

    private int attackPower;
    private String name;

    public Supernatural(int attackPower) {
        this.attackPower = attackPower;
    }

    public Supernatural(int attackPower, String name) {
        this.attackPower = attackPower;
        this.name = name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }

    public void attack(StrikeableInterface other) {
        int hpLeftOverAfterAttack = other.getHealth() - this.attackPower;
        other.setHealth(hpLeftOverAfterAttack);
    }
}