package org.example;

public class Room {

    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;
    private boolean isAvailable;

    public Room(boolean isAvailable, boolean isDirty, boolean isOccupied, double price, int numberOfBeds) {
        this.isAvailable = isAvailable;
        this.isDirty = isDirty;
        this.isOccupied = isOccupied;
        this.price = price;
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void checkIn(){
        this.isOccupied = true;
        this.isDirty = true;
    }
    public void checkout(){
        cleanroom();
        this.isAvailable = true;
        this.isOccupied = false;
    }
    public void cleanroom(){
        this.isDirty = false;
    }
}
