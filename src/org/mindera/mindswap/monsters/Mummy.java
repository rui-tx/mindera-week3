package org.mindera.mindswap.monsters;

import static org.mindera.mindswap.monsters.MonsterTypeEnum.MUMMY;

public class Mummy extends Monster{

    public Mummy() {
        super(MUMMY);
    }

    @Override
    public String toString() {
        return "This is a Mummy.";
    }
}