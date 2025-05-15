package org.dreamCar.data;

import org.dreamCar.model.Dealership;
import org.dreamCar.model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Vehicle> vehicle = new ArrayList<>();
    public static ArrayList<Dealership> dealership = new ArrayList<>();


//    public void deal(){
//
//        dealerships.add(new Dealership("D&B used Cars", "111 Old Benbrool RD", "817-555-5555"));
//
//    }


    public static List<Vehicle> getDealership(String file) {
       // Dealership dealership = null;
        try {
            BufferedReader buff = new BufferedReader(new FileReader(file));
            String dealershipInfo = buff.readLine();
            if (dealershipInfo == null) return null;
            String[] parts = dealershipInfo.split("\\|");
            String name = parts[0].trim();
            String address = parts[1].trim();
            String phone = parts[2].trim();
            Dealership d = new Dealership(name, address, phone);
            dealership.add(d);
           // buff.readLine();
//            String header = buff.readLine();
//            String[] dealerInfo = header.split("\\|");
//            dealership = new Dealership(dealerInfo[0], dealerInfo[1], dealerInfo[2]);
            String line;
            while ((line = buff.readLine()) != null) {
                String[] token = line.split("\\|");
                if (token.length == 8) {
                    int vin = Integer.parseInt(token[0]);
                    int year = Integer.parseInt(token[1]);
                    String make = token[2];
                    String model = token[3];
                    String vehicleType = token[4];
                    String color = token[5];
                    int odometer = Integer.parseInt(token[6]);
                    double price = Double.parseDouble(token[7]);

                   Vehicle v= new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                   vehicle.add(v);

                }
            }
            buff.close();
        } catch (FileNotFoundException e) {
            System.out.println("\nError ! File not found.");
        } catch (IOException e) {
            System.out.println("\nError ! Something went wrong.");
        }
        return vehicle;
    }
        public void saveDealership(Dealership dealership) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/dealership.csv"))) {

                writer.printf("%s|%s|%s\n",
                        dealership.getName(),
                        dealership.getAddress(),
                        dealership.getPhone()
                );

                // Write each vehicle
                for (Vehicle v : vehicle) {
                    writer.printf("%d|%d|%s|%s|%s|%s|%d|%.2f\n",
                            v.getVin(),
                            v.getYear(),
                            v.getMake(),
                            v.getModel(),
                            v.getVehicleType(),
                            v.getColor(),
                            v.getOdometer(),
                            v.getPrice()
                    );
                }

                System.out.println("Dealership saved to file.");

            } catch (IOException e) {
                System.out.println("Error saving dealership to file: " + e.getMessage());
            }
    }
}

