package org.example;

public class Reservation {
    private String roomType;
    private float price;
    private int numberOfNights;
    private boolean isWeekend;
    private float reservationTotal;

    public Reservation(String roomType, float price, int numberOfNights, boolean isWeekend, float reservationTotal) {
        this.roomType = roomType;
        this.price = price;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
        this.reservationTotal = reservationTotal;
    }
    public Reservation(String roomType){
        setRoomType(roomType);
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
        if(roomType.equalsIgnoreCase("king")){
            this.price = 139;
        }else if(roomType.equalsIgnoreCase("double")){
            this.price = 124;
        }
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public float getReservationTotal() {
        return reservationTotal;
    }

//    public void setReservationTotal(float reservationTotal) {
//        this.reservationTotal = reservationTotal;
//    }


}
