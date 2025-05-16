package org.dreamCar.model;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= minPrice && v.getPrice() <= maxPrice) {
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
    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getYear() >= minYear && v.getYear() <= maxYear) {
                result.add(v);
            }
        }
        return result;
    }
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color)) {
                result.add(v);
            }
        }
        return result;
    }
    public List<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getOdometer() >= minMileage && v.getOdometer() <= maxMileage) {
                result.add(v);
            }
        }
        return result;
    }
    public List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getType().equalsIgnoreCase(type)) {
                result.add(v);
            }
        }
        return result;
    }
}