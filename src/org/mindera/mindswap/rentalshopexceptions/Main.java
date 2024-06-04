package org.mindera.mindswap.rentalshopexceptions;

import org.mindera.mindswap.rockpaperscissors.Random;

import static org.mindera.mindswap.rentalshopexceptions.VehicleTypeE.CAR;

public class Main {
    public static void main(String[] args) {
        RentalShop shop1 = new RentalShop();
        Client client1 = new Client("Rui");

        client1.loanCar(shop1.getNewVehicle(CAR));

        client1.drive(Random.getRandomNumber(1, 200), Random.getRandomNumber(1, 100));
        //client1.refuel();

        shop1.returnVehicle(client1.deliverCurrentVehicle());
        System.out.println();

        shop1.printVehicleStats();
    }
}