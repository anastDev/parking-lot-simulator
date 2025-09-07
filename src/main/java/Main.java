package main.java;

import main.java.exceptions.CarAlreadyParked;
import main.java.exceptions.CarNotFound;
import main.java.exceptions.ParkingFullException;
import main.java.models.Car;
import main.java.models.ParkingLot;

public class Main {
    public static void main(String[] args) {
        ParkingLot parking = new ParkingLot(3);

        Car car1 = new Car("XMQ 234", "Toyota", "Yaris", false, 2004, "Nikos Papadopoulos");
        Car car2 = new Car("KNO 901", "BMW", "X5", false, 2008, "Maria Georgiou");
        Car car3 = new Car("ABC 789", "Audi", "A4", true, 2010, "John Smith");
        Car car4 = new Car("AMO 047", "Toyota", "Corolla", true, 2015, "Nikos Papadopoulos");

        //Parking cars
        try {
            parking.parkCar(car1);
            parking.parkCar(car2);
            parking.parkCar(car3);
            parking.parkCar(car4);
        } catch (ParkingFullException | CarAlreadyParked e) {
            System.out.println(e.getMessage());
        }

        //Checking cars
        try {
            parking.containsCar("AMO 047");
            parking.containsCar("SOM 091");
        } catch (CarNotFound e) {
            System.out.println(e.getMessage());
        }

        //Removing cars
        try {
            parking.removeCar("XMQ 234");
            parking.removeCar("SOM 091");
        } catch (CarNotFound e) {
            System.out.println(e.getMessage());
        }

        // Status of the Parking
        parking.showStatus();
        System.out.println("Available spots: " + parking.availableSpots());
        System.out.println("Is the parking full? " + parking.isFull());
        System.out.println("Is the parking empty? " + parking.isEmpty());
        System.out.println();

        //Other actions
        System.out.println("All cars: " + parking.getAllCars());
        System.out.println();

        System.out.println("Cars by make Toyota: ");
        parking.showCarsByMake("Toyota");

        System.out.println("Cars filtered by year: ");
        parking.getAllCars().forEach(car -> System.out.printf("%s (%d)%n", car.getLicencePlate(), car.getYear()));
        System.out.println();

        parking.clearParkingLot();
        parking.showStatus();
    }

}
