package org.mindera.mindswap.rentalshop;

public class Motorcycle extends VehicleBase{

    private final int MAX_DISTANCE = 80;

    public Motorcycle(int id, int consumptionValue, int maximumSpeed, VehicleTypeE type) {
        super(id, consumptionValue, maximumSpeed, type);

    }

    @Override
    public String toString() {
        return "This is a Motorcycle object.";
    }

    @Override
    public boolean drive(int distance, int time) {

        if (distance > MAX_DISTANCE) {
            System.out.println("Error! This vehicle type "+ this.getVehicleType() +" can only got up to 80km in distance.");
            return false;
        }

        return super.drive(distance, time);
    }
}
