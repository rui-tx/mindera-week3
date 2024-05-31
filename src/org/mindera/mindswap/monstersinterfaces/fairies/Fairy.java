package org.mindera.mindswap.monstersinterfaces.fairies;

import org.mindera.mindswap.monstersinterfaces.Supernatural;

public class Fairy extends Supernatural {
    public Fairy(int health, int attackPower) {
        super(health, attackPower);
    }

    public Fairy(int health, int attackPower, String name) {
        super(health, attackPower, name);
    }

}