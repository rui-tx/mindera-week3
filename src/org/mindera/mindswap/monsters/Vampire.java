package org.mindera.mindswap.monsters;

import static org.mindera.mindswap.monsters.MonsterTypeEnum.VAMPIRE;

public class Vampire extends Monster{

    public Vampire() {
        super(VAMPIRE);
    }

    @Override
    public String toString() {
        return "This is a Vampire.";
    }

}