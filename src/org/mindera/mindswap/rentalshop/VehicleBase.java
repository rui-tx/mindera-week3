package org.mindera.mindswap.rentalshop;

public abstract class VehicleBase {

    public static final int MAX_FUEL_LEVEL = 25;

    private int vehicleId;
    private VehicleTypeE vehicleType;
    private int consumptionValue;
    private int maximumSpeed;
    private int fuelLevel;

    VehicleBase(int vehicleId, int consumptionValue, int maximumSpeed, VehicleTypeE type) {
        this.vehicleId = vehicleId;
        this.consumptionValue = consumptionValue;
        this.maximumSpeed = maximumSpeed;
        this.vehicleType = type;
        this.fuelLevel = MAX_FUEL_LEVEL;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public VehicleTypeE getVehicleType() {
        return vehicleType;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public int getConsumptionValue() {
        return consumptionValue;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void decreaseFuelLevel(int fuelLevel) {
        this.fuelLevel -= fuelLevel;
    }

    public boolean drive(int distance, int time) {

        float checkKMperHour = (distance / ((float) time / 60));
        // check speed
        if(checkKMperHour > this.getMaximumSpeed()) {
            System.out.println("Error! Vehicle can't go that fast: " + checkKMperHour + "KM/h.");
            return false;
        }

        // check fuel
        float checkKMperL = ((float) distance / this.getConsumptionValue());
        if (checkKMperL > this.getFuelLevel()) {
            System.out.println("Error! Can't go that far, not enough fuel: " + checkKMperL + "Tank capacity is " + MAX_FUEL_LEVEL + "L");
            return false;
        }

        System.out.println("Vehicle travelled " + distance + " km at a speed of " + checkKMperHour + "KM/h and used " + checkKMperL + "L");
        this.decreaseFuelLevel((int) checkKMperL);
        System.out.println("Vehicle has " + this.getFuelLevel() + "L of fuel left.");
        return true;
    }

    public void refuel() {
        this.fuelLevel = MAX_FUEL_LEVEL;
    }
}