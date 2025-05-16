package org.dreamCar.contract;

import org.dreamCar.model.Vehicle;
import org.w3c.dom.ls.LSOutput;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    private static final String file = "src/main/java/org/dreamCar/contract/contracts.csv";

    public void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            StringBuilder sb = new StringBuilder();

            if (contract instanceof SalesContract) {
                SalesContract sc = (SalesContract) contract;
                sb.append("SALE|")
                        .append(sc.getDate()).append("|")
                        .append(sc.getCustomerName()).append("|")
                        .append(sc.getCustomerEmail()).append("|")
                        .append(getVehicleData(sc.getVehicle())).append("|")
                        .append(String.format("%.2f", sc.getVehicle().getPrice() * 0.05)).append("|")
                        .append("100.00|")
                        .append(sc.getVehicle().getPrice() < 10000 ? "295.00|" : "495.00|")
                        .append(String.format("%.2f", sc.getTotalPrice())).append("|")
                        .append(sc.isFinance() ? "YES|" : "NO|")
                        .append(String.format("%.2f", sc.getMonthlyPayment()));
            } else if (contract instanceof LeaseContract) {
                LeaseContract lc = (LeaseContract) contract;
                double endingValue = lc.getVehicle().getPrice() * 0.50;
                double leaseFee = lc.getVehicle().getPrice() * 0.07;
                sb.append("LEASE|")
                        .append(lc.getDate()).append("|")
                        .append(lc.getCustomerName()).append("|")
                        .append(lc.getCustomerEmail()).append("|")
                        .append(getVehicleData(lc.getVehicle())).append("|")
                        .append(String.format("%.2f", endingValue)).append("|")
                        .append(String.format("%.2f", leaseFee)).append("|")
                        .append(String.format("%.2f", lc.getTotalPrice())).append("|")
                        .append(String.format("%.2f", lc.getMonthlyPayment()));
            }

            writer.write(sb.toString());
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String getVehicleData(Vehicle vehicle) {
        return vehicle.getVin() + "|" +
                vehicle.getYear() + "|" +
                vehicle.getMake() + "|" +
                vehicle.getModel() + "|" +
                vehicle.getType() + "|" +
                vehicle.getColor() + "|" +
                vehicle.getOdometer() + "|" +
                String.format("%.2f", vehicle.getPrice());
    }
}