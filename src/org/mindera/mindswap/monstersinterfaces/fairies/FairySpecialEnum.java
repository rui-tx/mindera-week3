package org.mindera.mindswap.monstersinterfaces.fairies;

public enum FairySpecialEnum {
    TINKERBELL(10, "Tinkerbell"),
    FORTUNA(20, "Dama Fortuna"),
    BOB(30, "Fairy Bob");

    private final int attackPower;
    private final String name;

    FairySpecialEnum(int attackPower, String name) {
        this.attackPower = attackPower;
        this.name = name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }
}
