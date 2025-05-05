package org.example;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employee(int id, String name, String department, double payRate, double hoursWorked) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }
    public Employee(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public double getTotalPay(){
        double totalPay = this.payRate * this.hoursWorked;
        
        return totalPay;
    }
    public double getRegularHours(){
        double regularHours = 40;
        return regularHours;
    }
    public double getOvertimeHours(){
        double overtimeHours = 0;
        if(getHoursWorked() > getRegularHours()){
            overtimeHours = getHoursWorked() - getRegularHours();
        }
        return overtimeHours;
    }
    public void punchTimeCard(double timeIn, double timeOut){

        this.hoursWorked = timeOut - timeIn;
    }
}
