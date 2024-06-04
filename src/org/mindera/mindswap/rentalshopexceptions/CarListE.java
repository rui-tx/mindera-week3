package org.mindera.mindswap.rentalshopexceptions;

public enum CarListE {
    BMW(10, 120),
    TOYOTA(5, 100);

    private final int consuptionLevel;
    private final int maxSpeed;

    CarListE(int consuptionLevel, int maxSpeed) {
        this.consuptionLevel = consuptionLevel;
        this.maxSpeed = maxSpeed;
    }

    public int getConsuptionLevel() {
        return consuptionLevel;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}