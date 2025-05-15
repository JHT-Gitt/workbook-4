package org.dreamCar.contract;

public abstract class Contract {
    protected String contractType;
    protected String dateOfContract;
    protected String name;
    protected String email;
    protected int vehicleSold;
    protected double totalPrice;
    protected double monthPayment;


    public Contract(String contractType,String dateOfContract, String name, String email, int vehicleSold) {
        this.contractType = contractType;
        this.dateOfContract = dateOfContract;
        this.name = name;
        this.email = email;
        this.vehicleSold = vehicleSold;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(int vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
    public abstract double getTotalPrice();

    public abstract double getMonthPayment();



}
