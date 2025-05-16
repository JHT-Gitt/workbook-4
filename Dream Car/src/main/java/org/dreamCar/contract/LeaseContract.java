package org.dreamCar.contract;

import org.dreamCar.model.Vehicle;


public class LeaseContract extends Contract {
    private static final double leaseRate = 0.04 / 12;
    private static final int leaseMonths = 36;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
    }
    @Override
    public double getTotalPrice() {
        double endingValue = vehicle.getPrice() * 0.50;
        double leaseFee = vehicle.getPrice() * 0.07;
        return endingValue + leaseFee;
    }
    @Override
    public double getMonthlyPayment() {
        double principal = getTotalPrice();
        return (principal * leaseRate) / (1 - Math.pow(1 + leaseRate, -leaseMonths));
    }
}