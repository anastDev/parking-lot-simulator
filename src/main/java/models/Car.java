package main.java.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Car {
    private String licencePlate;
    private String make;
    private String model;
    private boolean isElectric;
    private int year;
    private String ownerName;
    private LocalDateTime entryTime;

    public Car () {}

    public Car(String licencePlate, String make, String model, boolean isElectric, int year, String ownerName) {
        this.licencePlate = licencePlate;
        this.make = make;
        this.model = model;
        this.isElectric = isElectric;
        this.year = year;
        this.ownerName = ownerName;
    }


    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String entryTimeStr = entryTime != null ? entryTime.format(formatter) : "Not parked yet";

        return String.format("%s - %s %s (%d), Owner: %s, Entry: %s \n",
                licencePlate, make, model, year, ownerName, entryTimeStr);
    }

}
