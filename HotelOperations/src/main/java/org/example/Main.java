package org.example;

public class Main {
    public static void main(String[] args) {

        Reservation reserve = new Reservation("king");
        System.out.println(reserve.getRoomType());
        System.out.println(reserve.getPrice());

        Employee e = new Employee();
        e.punchTimeCard(5,13);
        System.out.println(e.getHoursWorked());


        //Room r = new Room();
//r.checkIn();
    }
}