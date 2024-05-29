package org.mindera.mindswap.monsters;

import static org.mindera.mindswap.monsters.MonsterTypeEnum.WEREWOLF;

public class Werewolf extends Monster{

    public Werewolf() {
        super(WEREWOLF.getHealth(), WEREWOLF.getAttackPower());
    }

    @Override
    public String toString() {
        return "Werewolf";
    }
}