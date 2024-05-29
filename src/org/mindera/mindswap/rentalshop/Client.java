package org.mindera.mindswap.rentalshop;

public class Client {

    private String name;
    private VehicleBase vehicle;

    public Client(String name) {
        this.name = name;
    }

    public void loanCar(VehicleBase vehicle) {
        if(vehicle == null) {
            System.out.println("That's not a vehicle. Try again.");
            return;
        }

        this.vehicle = vehicle;
    }

    public void drive(int distance, int time) {
        if(this.vehicle == null) {
            System.out.println("Can't drive without a vehicle. Loan one first.");
            return;
        }

        this.vehicle.drive(distance, time);
    }

    public void refuel () {
        if(this.vehicle == null) {
            System.out.println("You don't have a vehicle to refuel. Loan one first.");
            return;
        }

        System.out.println("Client has refuel the vehicle.");
        this.vehicle.refuel();
    }

    public VehicleBase deliverCurrentVehicle() {
        if(this.vehicle == null) {
            System.out.println("You don't have a vehicle to deliver. Loan one first.");
            return null;
        }

        VehicleBase currentVehivcle = this.vehicle;
        this.vehicle = null;

        return currentVehivcle;
    }

    public void getCarType() {
        System.out.println(this.vehicle.getMaximumSpeed());
    }
}