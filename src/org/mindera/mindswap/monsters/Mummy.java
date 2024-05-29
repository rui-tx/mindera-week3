package org.mindera.mindswap.monsters;

import static org.mindera.mindswap.monsters.MonsterTypeEnum.MUMMY;

public class Mummy extends Monster{

    private int numberOfConsecutiveAttacks;

    public Mummy() {
        super(MUMMY.getHealth(), MUMMY.getAttackPower());
    }

    @Override
    public String toString() {
        return "Mummy";
    }

    @Override
    public void attack(Monster other) {
        if (numberOfConsecutiveAttacks == 2) {
            System.out.println("Mummy tries to attack, fails, hits his head and loses 5 health!");
            this.decreaseHealth(5);
            this.numberOfConsecutiveAttacks = 0;
            return;
        } else {
            this.numberOfConsecutiveAttacks++;
        }

        super.attack(other);
    }
}