package org.mindera.mindswap.monstersinterfaces.strikeable.monsters;

import static org.mindera.mindswap.monsters.MonsterTypeEnum.WEREWOLF;

public class Werewolf extends Monster {

    public Werewolf() {
        super(WEREWOLF.getHealth(), WEREWOLF.getAttackPower());
    }

    public Werewolf(int health, int attackPower, String name) {
        super(health, attackPower, name);
    }

    @Override
    public String toString() {
        if (this.getName() != null) {
            return this.getName();
        }
        return "Werewolf";
    }
}