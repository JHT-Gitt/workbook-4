package org.example;

public class Employee {
    private int id;
    private String name;
    private String department;
    private float payRate;
    private float hoursWorked;

    public Employee(int id, String name, String department, float payRate, float hoursWorked) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
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

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public float getTotalPay(){
        float totalPay = this.payRate * this.hoursWorked;
        
        return totalPay;
    }
    public float getRegularHours(){
        float regularHours = 40;
        return regularHours;
    }
    public float getOvertimeHours(){
        float overtimeHours = 0;
        if(getHoursWorked() > getRegularHours()){
            overtimeHours = getHoursWorked() - getRegularHours();
        }
        return overtimeHours;
    }
    
}
