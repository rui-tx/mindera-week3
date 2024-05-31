package org.mindera.mindswap.monstersinterfaces.strikeable.monsters;

public enum MummySpecialEnum {
    IMHOTEP(20, 20, "Imhotep, The High Priest of Ra"),
    TUTA(25, 25, "King Tutankhamun, High Ruler of The Sands"),
    OTZI(25, 15, "Otzi, The Iceman ");

    private final int health;
    private final int attackPower;
    private final String name;

    MummySpecialEnum(int health, int attackPower, String name) {
        this.health = health;
        this.attackPower = attackPower;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }
}
