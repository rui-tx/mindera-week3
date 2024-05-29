package org.mindera.mindswap.rentalshop;

import org.mindera.mindswap.rockpaperscissors.Random;

import static org.mindera.mindswap.rentalshop.CarListE.*;
import static org.mindera.mindswap.rentalshop.VehicleTypeE.CAR;
import static org.mindera.mindswap.rentalshop.VehicleTypeE.MOTORCYCLE;

public class RentalShop {

    private VehicleBase[] vehicleList;

    public RentalShop() {

        this.vehicleList = new VehicleBase[10];
        this.vehicleListInit();
    }

    private void vehicleListInit() {
        for (int i = 0; i < this.vehicleList.length; i++) {
            if (Random.getRandomNumber(0,1) == 0) {
                this.vehicleList[i] = new Car(i, TOYOTA);
            } else {
                this.vehicleList[i] = new Motorcycle(i,5, 100, MOTORCYCLE);
            }
        }
    }

    public VehicleBase getNewVehicle(VehicleTypeE type) {
        for (int i = 0; i < this.vehicleList.length; i++) {
            if (this.vehicleList[i] != null) {
                if(this.vehicleList[i].getVehicleType().equals(type)) {
                    VehicleBase vehicle = this.vehicleList[i];
                    this.vehicleList[i] = null;
                    return vehicle;
                }
            }
        }

        return null;
    }

    public void returnVehicle(VehicleBase vehicle) {
        if(vehicle == null) {
            System.out.println("That is not a valid vehicle. Can't receive it.");
            return;
        }

        for (int i = 0; i < this.vehicleList.length; i++) {
            if (this.vehicleList[i] != null) {
                if (vehicle.getVehicleId() == this.vehicleList[i].getVehicleId()) {
                    System.out.println("Error! Vehicle is already on the Rental shop.");
                    return;
                }
            }
        }

        if (vehicle.getFuelLevel() < 25) {
            float fee = (float) ((25 - vehicle.getFuelLevel()) * 2.5);
            System.out.println("Client has to pay additional fee: " + fee + "€");
        }

        vehicleList[vehicle.getVehicleId()] = vehicle;
        System.out.println("Vehicle returned to Rental shop.");
    }

    public void printVehicleStats () {
        int vehiclesBeingUsed = 0;

        for (int i = 0; i < this.vehicleList.length; i++) {
            if(this.vehicleList[i] == null) {
                vehiclesBeingUsed++;
            }
        }

        System.out.println(">>> Vehicle Stats <<<");
        System.out.println("Total being used: " + vehiclesBeingUsed);
        System.out.println("Vehicles left: " + (this.vehicleList.length - vehiclesBeingUsed));
    }
}