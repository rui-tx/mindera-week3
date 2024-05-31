package org.mindera.mindswap.monstersinterfaces.strikeable.monsters;

import org.mindera.mindswap.monstersinterfaces.strikeable.StrikeableInterface;

import static org.mindera.mindswap.monsters.MonsterTypeEnum.MUMMY;

public class Mummy extends Monster {

    private final int healthLostDueToConsecutiveAttacks = 5;
    private int numberOfConsecutiveAttacks;

    public Mummy() {
        super(MUMMY.getHealth(), MUMMY.getAttackPower());
    }

    public Mummy(int health, int attackPower, String name) {
        super(health, attackPower, name);
    }

    @Override
    public String toString() {
        if (this.getName() != null) {
            return this.getName();
        }
        return "Mummy";
    }

    @Override
    public void attack(StrikeableInterface other) {
        if (numberOfConsecutiveAttacks == 2) {
            System.out.println(this + " tries to attack, fails, hits his head and loses " + healthLostDueToConsecutiveAttacks + " health!");
            this.decreaseHealth(healthLostDueToConsecutiveAttacks);
            this.numberOfConsecutiveAttacks = 0;
            return;
        } else {
            this.numberOfConsecutiveAttacks++;
        }

        super.attack(other);
    }
}