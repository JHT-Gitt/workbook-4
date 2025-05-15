package org.dreamCar.model;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private static List<Vehicle> inventory;
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getYear() >= min && v.getYear() <= max) {
                result.add(v);
            }
        }
        return result;
    }

    public void getVehiclesByColor(String color) {

//        List<Vehicle> result = new ArrayList<>();
      ;
        for (Vehicle v : inventory) {
            String c = v.getColor();
            if (c.equalsIgnoreCase(color)) {

                System.out.printf("\n%-10d %-10d  %-10s %-10s %-10s %-10s  %-10d %-10.2f" ,
                        v.getVin(),v.getYear(),v.getMake(),v.getModel(),
                        v.getVehicleType(),v.getColor(),v.getOdometer(),v.getPrice());
            }
        }

    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getOdometer() >= min && v.getOdometer() <= max) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getVehicleType().equalsIgnoreCase(vehicleType)) {
                result.add(v);
            }
        }
        return result;
    }

    public static void getAllVehicles(List<Vehicle> inventory) {
       for(Vehicle v : inventory){
           System.out.printf(YELLOW + "%-10d %-10d  %-10s %-10s %-10s %-10s  %-10d %-10.2f\n" + RESET,
                   v.getVin(),v.getYear(),v.getMake(),v.getModel(),
                   v.getVehicleType(),v.getColor(),v.getOdometer(),v.getPrice());
       }
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public static void removeVehicle(List<Vehicle> inventory ,int vin) {
            inventory.removeIf(in -> in.getVin() == vin);
    }


}
