package org.dreamCar.contract;

import org.dreamCar.model.Vehicle;

public class SalesContract extends Contract {
    private static final double taxRate = 0.05;
    private static final double recordingFee = 100.0;
    private static final double processingLow = 295.0;
    private static final double processingHigh = 495.0;
    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean finance) {
        super(date, customerName, customerEmail, vehicle);
        this.finance = finance;
    }

    @Override
    public double getTotalPrice() {
        double salesTax = vehicle.getPrice() * taxRate;
        double processingFee = vehicle.getPrice() < 10000 ? processingLow : processingHigh;
        return vehicle.getPrice() + salesTax + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) return 0.0;

        double principal = getTotalPrice();
        double rate;
        int months;

        if (vehicle.getPrice() >= 10000) {
            rate = 0.0425 / 12;
            months = 48;
        } else {
            rate = 0.0525 / 12;
            months = 24;
        }

        return (principal * rate) / (1 - Math.pow(1 + rate, -months));
    }

    public boolean isFinance() {
        return finance;
    }
}