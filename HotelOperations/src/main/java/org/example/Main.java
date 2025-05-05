package org.example;

public class Main {
    public static void main(String[] args) {

        Reservation reserve = new Reservation("king");
        System.out.println(reserve.getRoomType());
        System.out.println(reserve.getPrice());


    }
}