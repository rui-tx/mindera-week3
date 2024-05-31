package org.mindera.mindswap.monstersinterfaces.fairies;

import org.mindera.mindswap.monstersinterfaces.Supernatural;
import org.mindera.mindswap.monstersinterfaces.strikeable.StrikeableInterface;

public class Fairy extends Supernatural {
    public Fairy(int attackPower) {
        super(attackPower);
    }

    public Fairy(int attackPower, String name) {
        super(attackPower, name);
    }

    public void attack(StrikeableInterface p1Monster, StrikeableInterface p2Monster) {

        System.out.println("Fairy attacks both players!");
        super.attack(p1Monster);
        super.attack(p2Monster);
        

    }
}