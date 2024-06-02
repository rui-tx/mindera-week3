package org.mindera.mindswap.monstersinterfaces.strikeable;

public interface StrikeableInterface {
    int getHealth();

    void setHealth(int health);

    void decreaseHealth(int decreaseAmount);

    boolean isDead();

    int getAttackPower();
}
