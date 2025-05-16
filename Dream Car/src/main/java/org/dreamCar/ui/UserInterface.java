package org.dreamCar.ui;
import org.dreamCar.Main;
import org.dreamCar.contract.Contract;
import org.dreamCar.contract.ContractDataManager;
import org.dreamCar.contract.LeaseContract;
import org.dreamCar.contract.SalesContract;
import org.dreamCar.data.DealershipFileManager;
import org.dreamCar.model.Dealership;
import org.dreamCar.model.Vehicle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private final Scanner sc = new Scanner(System.in);

    public void display() {
        init();

        int enter;
        System.out.println("\nWELCOME BUYER !");
        System.out.println(" 1 - Find vehicles price range");
        System.out.println(" 2 - Find vehicles by make/model");
        System.out.println(" 3 - Find vehicles by year");
        System.out.println(" 4 - Find vehicle by color");
        System.out.println(" 5 - Find vehicles by mileage");
        System.out.println(" 6 - Find vehicles by type (Sedan, Truck, SUV, Van)");
        System.out.println(" 7 - List all vehicles");
        System.out.println(" 8 - Add vehicle");
        System.out.println(" 9 - Remove vehicle");
        System.out.println("10 - List all Contracts");
        System.out.println("11 - Sell/Lease Vehicle");
        System.out.println("99 - Quit");

        while (true) {
            try {
                System.out.print("\nEnter: ");
                enter = sc.nextInt();
                sc.nextLine();

                switch (enter) {
                    case 1 -> processGetByPriceRequest();
                    case 2 -> processGetByMakeModelRequest();
                    case 3 -> processGetByYearRequest();
                    case 4 -> processGetByColorRequest();
                    case 5 -> processGetByMileageRequest();
                    case 6 -> processGetByTypeRequest();
                    case 7 -> processAllVehiclesRequest();
                    case 8 -> processAddVehicleRequest();
                    case 9 -> processRemoveVehicleRequest();
                    case 10 -> processListAllContracts();
                    case 11 -> processSellOrLeaseVehicle();
                    case 99 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid input. Please choose a number from the menu.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }

    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();
        dealership = dfm.getDealership();
    }
    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.printf("%-8d | %-8d | %-10s | %-10s | %-10s | %-8s | %6d mi | $%-10.2f\n",
                        v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                        v.getType(), v.getColor(), v.getOdometer(), v.getPrice());
            }
        }
    }
    private void processGetByPriceRequest() {
        System.out.print("Minimum price: ");
        double min = sc.nextDouble();
        System.out.print("Maximum price: ");
        double max = sc.nextDouble();
        sc.nextLine();

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }
    private void processGetByMakeModelRequest() {
        System.out.print("Make: ");
        String make = sc.nextLine();
        System.out.print("Model: ");
        String model = sc.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }
    private void processGetByYearRequest() {
        System.out.print("Start year: ");
        int min = sc.nextInt();
        System.out.print("End year: ");
        int max = sc.nextInt();
        sc.nextLine();

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }
    private void processGetByColorRequest() {
        System.out.print("Color: ");
        String color = sc.nextLine();
        displayVehicles(dealership.getVehiclesByColor(color));
    }
    private void processGetByMileageRequest() {
        System.out.print("Minimum mileage: ");
        int min = sc.nextInt();
        System.out.print("Maximum mileage: ");
        int max = sc.nextInt();
        sc.nextLine();

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }
    private void processGetByTypeRequest() {
        System.out.print("Type (Sedan, Truck, SUV, Van): ");
        String type = sc.nextLine();
        displayVehicles(dealership.getVehiclesByType(type));
    }
    private void processAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }
    private void processAddVehicleRequest() {
        System.out.println("Enter vehicle details:");
        System.out.print("VIN: ");
        int vin = sc.nextInt();
        System.out.print("Year: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Make: ");
        String make = sc.nextLine();
        System.out.print("Model: ");
        String model = sc.nextLine();
        System.out.print("Type: ");
        String type = sc.nextLine();
        System.out.print("Color: ");
        String color = sc.nextLine();
        System.out.print("Odometer: ");
        int odometer = sc.nextInt();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        new DealershipFileManager().saveDealership(dealership);
        System.out.println("Vehicle added.");
    }
    private void processRemoveVehicleRequest() {
        System.out.print("Enter VIN to remove: ");
        int vin = sc.nextInt();
        sc.nextLine();

        Vehicle found = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                found = v;
                break;
            }
        }
        if (found != null) {
            dealership.removeVehicle(found);
            new DealershipFileManager().saveDealership(dealership);
            System.out.println("Vehicle removed.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }
    private void processSellOrLeaseVehicle() {
        System.out.print("Enter VIN to sell/lease: ");
        int vin = sc.nextInt();
        sc.nextLine();

        Vehicle found = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                found = v;
                break;
            }
        }
        if (found == null) {
            System.out.println("Vehicle not found.");
            return;
        }
        System.out.print("Customer name: ");
        String name = sc.nextLine();
        System.out.print("Customer email: ");
        String email = sc.nextLine();
        System.out.print("Date (YYYYMMDD): ");
        String date = sc.nextLine();

        System.out.print("Contract type (SALE/LEASE): ");
        String type = sc.nextLine().trim().toUpperCase();

        Contract contract = null;
        if (type.equals("SALE")) {
            System.out.print("Finance? (yes/no): ");
            boolean finance = sc.nextLine().equalsIgnoreCase("yes");
            contract = new SalesContract(date, name, email, found, finance);
        } else if (type.equals("LEASE")) {
            int currentYear = java.time.Year.now().getValue();
            if (found.getYear() < currentYear - 3) {
                System.out.println("Cannot lease a vehicle older than 3 years.");
                return;
            }
            contract = new LeaseContract(date, name, email, found);
        } else {
            System.out.println("Invalid contract type.");
            return;
        }

        new ContractDataManager().saveContract(contract);
        dealership.removeVehicle(found);
        new DealershipFileManager().saveDealership(dealership);
        System.out.printf("Contract saved. Monthly Payment: $%.2f\n", contract.getMonthlyPayment());
    }

    private void processListAllContracts() {
        System.out.println("=== All Contracts ===");
        File file = new File("src/main/java/org/dreamCar/contract/contracts.csv");

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No contract file found.");
        }
    }
}

