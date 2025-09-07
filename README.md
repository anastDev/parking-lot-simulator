# 🚗 Parking Lot Simulator

**Parking Lot Simulator** is a simple Java project that manages cars entering and leaving a parking lot.

---

## ✨Features

- Park a car and check if parking is full or the car is already parked.

-  Show parking status of occupied spots, available spots, and car details.

- Search cars by license plate or brand.

- Sort cars by year of manufacture.

- Track entry time (each car records its entry timestamp).

- Clear parking lot and remove all cars.

- Remove a car and check if it exists.

---

## 📌 Example Output

``` java
Parking successful. Car Plate: XMQ 234 added successfully
Parking successful. Car Plate: KNO 901 added successfully
Parking successful. Car Plate: ABC 789 added successfully

Occupied spots: 3/3
Parked cars:
- XMQ 234 (Nikos Papadopoulos)
- KNO 901 (Maria Georgiou)
- ABC 789 (John Smith)
```

---

## 🛠️ Key Components

- Queue and Set collections

- LocalDateTime for entry timestamps

- Custom exceptions (ParkingFullException, CarAlreadyParked, CarNotFound)

### 📌 Usage Example

```java
ParkingLot parking = new ParkingLot(3);

Car car1 = new Car("XMQ 234", "Toyota", "Yaris", false, 2004, "Nikos Papadopoulos");
parking.parkCar(car1);

parking.showStatus();
parking.containsCar("XMQ 234");
parking.removeCar("XMQ 234");
```
---
