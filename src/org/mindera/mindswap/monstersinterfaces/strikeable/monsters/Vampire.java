package org.mindera.mindswap.monstersinterfaces.strikeable.monsters;

import org.mindera.mindswap.monstersinterfaces.strikeable.StrikeableInterface;
import org.mindera.mindswap.rockpaperscissors.Random;

import static org.mindera.mindswap.monsters.MonsterTypeEnum.VAMPIRE;

public class Vampire extends Monster {

    private int increaseHealthChance = 5;

    public Vampire() {
        super(VAMPIRE.getHealth(), VAMPIRE.getAttackPower());
    }

    public Vampire(int health, int attackPower, String name) {
        super(health, attackPower, name);
    }

    @Override
    public String toString() {
        if (this.getName() != null) {
            return this.getName();
        }
        return "Vampire";
    }

    @Override
    public void attack(StrikeableInterface other) {
        //int increaseHealthChance = Random.getRandomNumber(1, 5); // 1 in 5
        if (Random.getRandomNumber(1, this.increaseHealthChance) == this.increaseHealthChance) {
            System.out.println(">>> Critical Hit! " + this + " bites the enemy! Health increase by " + this.getAttackPower() + " points <<<");
            this.increaseHealth(this.getAttackPower());
        }

        super.attack(other);
    }

    private void increaseHealth(int increaseAmount) {
        int health = this.getHealth() + increaseAmount;
        this.setHealth(health);
    }
}