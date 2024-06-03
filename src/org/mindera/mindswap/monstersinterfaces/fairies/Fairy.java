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

    @Override
    public String toString() {
        if (this.getName() != null) {
            return this.getName();
        }
        return "Fairy";
    }

    public void attack(StrikeableInterface p1Monster, StrikeableInterface p2Monster) {

        System.out.println(this.getName() + " appears and attacks both players!");
        super.attack(p1Monster);
        super.attack(p2Monster);


    }
}