package org.example;

public class Main {
    public static void main(String[] args) {

//        Room r = new Room("King");
//        System.out.println(r.getRoomType()); // Output: king
//        System.out.println(r.getPrice());

        Reservation reserve = new Reservation("king");
        System.out.println(reserve.getRoomType());
        System.out.println(reserve.getPrice());


    }
}