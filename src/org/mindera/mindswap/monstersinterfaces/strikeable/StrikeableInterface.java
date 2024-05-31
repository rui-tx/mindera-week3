package org.mindera.mindswap.monstersinterfaces.strikeable;

import org.mindera.mindswap.monstersinterfaces.Supernatural;

public interface StrikeableInterface {

    int getHealth();

    void setHealth(int health);

    int getAttackPower();

    String getName();

    void attack(Supernatural other);

    void increaseHealth(int increaseAmount);

    void decreaseHealth(int decreaseAmount);

    boolean isDead();
}
