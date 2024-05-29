package org.mindera.mindswap.monsters;

import org.mindera.mindswap.rockpaperscissors.Random;

import static org.mindera.mindswap.monsters.MonsterTypeEnum.VAMPIRE;

public class Vampire extends Monster{

    public Vampire() {
        super(VAMPIRE.getHealth(), VAMPIRE.getAttackPower());
    }

    @Override
    public String toString() {
        return "Vampire";
    }

    @Override
    public void attack(Monster other) {
        int increaseHealthChance = Random.getRandomNumber(1,5); // 1 in 5
        if (increaseHealthChance == 5) {
            System.out.println(">>> Critical Hit! Vampire bites the enemy! Health increase by " + VAMPIRE.getHealth() + " points <<<");
            this.increaseHealth(VAMPIRE.getAttackPower());
        }

        super.attack(other);
    }
}