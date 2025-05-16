package org.dreamCar.data;

import org.dreamCar.model.Dealership;
import org.dreamCar.model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager {
    private static final String file= "src/main/java/org/dreamCar/data/inventory.csv";

    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String dealershipInfo = reader.readLine();
            if (dealershipInfo == null) return null;

            String[] parts = dealershipInfo.split("\\|");
            String name = parts[0];
            String address = parts[1];
            String phone = parts[2];

            dealership = new Dealership(name, address, phone);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] vehicleData = line.split("\\|");

                int vin = Integer.parseInt(vehicleData[0]);
                int year = Integer.parseInt(vehicleData[1]);
                String make = vehicleData[2];
                String model = vehicleData[3];
                String type = vehicleData[4];
                String color = vehicleData[5];
                int odometer = Integer.parseInt(vehicleData[6]);
                double price = Double.parseDouble(vehicleData[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicle);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            for (Vehicle v : dealership.getAllVehicles()) {
                String vehicleLine = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                        v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                        v.getType(), v.getColor(), v.getOdometer(), v.getPrice());
                writer.write(vehicleLine);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving dealership file: " + e.getMessage());
        }
    }
}