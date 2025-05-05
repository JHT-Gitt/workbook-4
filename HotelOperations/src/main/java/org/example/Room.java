package org.example;

public class Room {

    private int numberOfBeds;
    private float price;
    private boolean isOccupied;
    private boolean isDirty;
    private boolean isAvailable;

    public Room(boolean isAvailable, boolean isDirty, boolean isOccupied, float price, int numberOfBeds) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
