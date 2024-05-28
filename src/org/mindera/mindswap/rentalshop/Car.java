package org.mindera.mindswap.rentalshop;

public class Car extends VehicleBase {

    public Car(int id, int consumptionValue, int maximumSpeed, VehicleTypeE type) {
        super(id, consumptionValue, maximumSpeed, type);
    }

    @Override
    public String toString() {
        return "This is a Car object.";
    }
}