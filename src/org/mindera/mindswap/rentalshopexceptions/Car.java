package org.mindera.mindswap.rentalshopexceptions;

public class Car extends VehicleBase {

    public Car(int id, int consumptionValue, int maximumSpeed, VehicleTypeE type) {
        super(id, consumptionValue, maximumSpeed, type);
    }

    public Car(int id, CarListE car) {
        super(id, car);
    }

    @Override
    public String toString() {
        return "This is a Car object.";
    }
}