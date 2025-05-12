package org.dreamCar.data;

import org.dreamCar.model.Dealership;
import org.dreamCar.model.Vehicle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Vehicle> vehicle = new ArrayList<>();
//    public static  ArrayList<Dealership> dealership = new ArrayList<>();
    public static List<Vehicle> getDealership(String file) {


        try {
            BufferedReader buff = new BufferedReader(new FileReader(file));
//            String dealershipInfo = buff.readLine();
//            if (dealershipInfo == null) return null;

//            String[] parts = dealershipInfo.split("\\|");
//            String name = parts[0].trim();
//            String address = parts[1].trim();
//            String phone = parts[2].trim();
//
//            //dealership = new Dealership(name, address, phone);
            buff.readLine();
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
        // Save dealership to file
    }
}

