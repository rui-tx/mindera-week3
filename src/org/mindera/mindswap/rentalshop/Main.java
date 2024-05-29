package org.mindera.mindswap.rentalshop;

import org.mindera.mindswap.rockpaperscissors.Random;

import static org.mindera.mindswap.rentalshop.VehicleTypeE.CAR;
import static org.mindera.mindswap.rentalshop.VehicleTypeE.MOTORCYCLE;

public class Main {
    public static void main(String[] args) {
        RentalShop shop1 = new RentalShop();
        Client client1 = new Client("Rui");

        client1.loanCar(shop1.getNewVehicle(CAR));

        client1.drive(Random.getRandomNumber(1,200), Random.getRandomNumber(1,100));
        //client1.refuel();

        shop1.returnVehicle(client1.deliverCurrentVehicle());
        System.out.println();

        // errors
        //client1.drive(80, 100);
        //shop1.returnVehicle(client1.deliverCurrentVehicle());

        shop1.printVehicleStats();

        /*
        VehicleBase vehicle1 = shop1.getNewVehicle(CAR);
        if (vehicle1 == null) {
            System.out.println("No vehicle of type select available.");
            return;
        }

        VehicleBase vehicle2 = shop1.getNewVehicle(MOTORCYCLE);
        if (vehicle2 == null) {
            System.out.println("No vehicle of type select available.");
            return;
        }

        if (!vehicle1.drive(Random.getRandomNumber(1,200), Random.getRandomNumber(1,100))) {
            shop1.returnVehicle(vehicle1);
        } else {
            if (Random.getRandomNumber(0,1) == 0) {
                vehicle1.refuel();
            }
            shop1.returnVehicle(vehicle1);
        }

        if (!vehicle2.drive(Random.getRandomNumber(1,200), Random.getRandomNumber(1,100))) {
            shop1.returnVehicle(vehicle2);
        } else {
            if (Random.getRandomNumber(0, 1) == 0) {
                vehicle2.refuel();
            }
            shop1.returnVehicle(vehicle2);
        }

         */


    }
}