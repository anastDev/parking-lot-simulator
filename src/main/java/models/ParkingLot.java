package main.java.models;

import main.java.exceptions.CarAlreadyParked;
import main.java.exceptions.CarNotFound;
import main.java.exceptions.ParkingFullException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ParkingLot {
    private int capacity;
    Queue<Car> occupiedSpots;
    Set<String> parkedCars;

    public ParkingLot() {}

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.occupiedSpots = new LinkedList<>();
        this.parkedCars = new HashSet<>();
    }

    public void parkCar(Car car) throws ParkingFullException, CarAlreadyParked {
        String plate = car.getLicencePlate();

        if (isFull()) {
          throw new ParkingFullException("No available parking spots!");
        }

        if (parkedCars.contains(plate)) {
            throw new CarAlreadyParked("Car already parked!");
        }

        occupiedSpots.add(car);
        parkedCars.add(plate);
        car.setEntryTime(LocalDateTime.now());
        System.out.printf("Parking successful. Car with licence plate: %s added successfully. \n", plate);

    }

    public void removeCar(String licencePlate) throws CarNotFound{
        if (!parkedCars.contains(licencePlate)) {
           throw new CarNotFound("Car doesn't exist. Can't remove it.");
        }

        parkedCars.remove(licencePlate);
        occupiedSpots.removeIf(car -> car.getLicencePlate().equals(licencePlate));
        System.out.println("Car removed successfully!");
    }

    public void showStatus() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.printf("Occupied spots: %d/%d%n", occupiedSpots.size(), capacity);
        System.out.println("Parked cars: ");

        if (occupiedSpots.isEmpty()) {
            System.out.println("No parked cars found!");
        }

        for (Car car : occupiedSpots) {
            String entryTimeStr = car.getEntryTime() != null
                    ? car.getEntryTime().format(formatter)
                    : "Not parked yet";
            System.out.printf("- %s (%s), Entry: %s%n",
                    car.getLicencePlate(), car.getOwnerName(), entryTimeStr);
        }

    }

    public boolean isFull() {
        return occupiedSpots.size() >= capacity;
    }

    public boolean isEmpty() {
        return occupiedSpots.isEmpty();
    }

    public int availableSpots() {
        return capacity - occupiedSpots.size();
    }

    public boolean containsCar(String licencePlate) throws CarNotFound {
        if (parkedCars.contains(licencePlate)) {
            System.out.printf("Car with licence plate %s has been found. \n", licencePlate);
            return true;
        } else {
            throw new CarNotFound("No car with licence plate: " + licencePlate + "is found!");
        }
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(occupiedSpots);
    }

    public void clearParkingLot() {
        occupiedSpots.clear();
        parkedCars.clear();
        System.out.println("Parking lot has been cleared!");
    }

    public void showCarsByMake(String brand) {
        for (Car car : occupiedSpots) {
            if (car.getMake().equalsIgnoreCase(brand)) {
                System.out.printf("-%s (%s)%n \n", car.getLicencePlate(), car.getOwnerName());
            }
        }
    }

    public List<Car> getCarsSortedByYear() {
        return occupiedSpots.stream()
                .sorted(Comparator.comparingInt(Car::getYear))
                .toList();
    }
}
