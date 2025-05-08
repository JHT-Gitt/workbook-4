package org.example;

public class Main {
    public static void main(String[] args) {

        Reservation reserve = new Reservation("king");
        System.out.println(reserve.getRoomType());
        System.out.println(reserve.getPrice());

        Employee e = new Employee();
     //   e.punchTimeCard(5,15);
        //System.out.println(e.getHoursWorked());
        e.setPayRate(20);
        e.setHoursWorked(45);

        System.out.println("Overtime Hours "+e.getOvertimeHours());
        System.out.println(e.getTotalPay());



        //Room r = new Room();
//r.checkIn();
    }
}