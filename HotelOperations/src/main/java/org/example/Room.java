package org.example;

public class Room {

    private int numberOfBeds;
    private double price;
    boolean isOccupied;
    boolean isDirty;
    boolean isAvailable;

    public Room(boolean isAvailable, boolean isDirty, boolean isOccupied, double price, int numberOfBeds) {
        this.isAvailable = isAvailable;
        this.isDirty = isDirty;
        this.isOccupied = isOccupied;
        this.price = price;
        this.numberOfBeds = numberOfBeds;
    }

//    public Room(){
//
//    }

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
        if(this.isOccupied){
            throw new IllegalStateException("\nError ! Can't check in. Room is Occupied.");
        }
        if(this.isDirty){
            throw new IllegalStateException("\nError ! Can't check in. Room is Dirty");
        }
        this.isOccupied = true;
        this.isDirty = true;
    }
    public void checkout(){
        this.isOccupied = false;
        cleanroom();
        this.isAvailable = true;
    }
    public void cleanroom(){
        if (this.isOccupied) {
            throw new IllegalStateException("\nError ! Can't clean an occupied room.");
        }
        this.isDirty = false;
    }
}
