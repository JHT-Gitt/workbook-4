package org.dreamCar.ui;

import org.dreamCar.Main;
import org.dreamCar.contract.ContractDataManager;
import org.dreamCar.contract.SalesContract;
import org.dreamCar.data.DealershipFileManager;
import org.dreamCar.model.Dealership;
import org.dreamCar.model.Vehicle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.dreamCar.data.DealershipFileManager.scanner;

public class UserInterface {
    static Scanner sc = new Scanner(System.in);
   // public static List<Dealership> dealership = new ArrayList<>();
   private static Dealership dealership;
 //   public UserInterface() {
      //  dealership = new DealershipFileManager().getDealership();
 //   }

    public static void display(List<Vehicle> vehicle) {
        int enter;
        String file="";

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
        System.out.println(" 10 - List all Contract");
        System.out.println(" 11 - Sell/Lease Vehicle");
        System.out.println(" 99 - Quit");

        while(true){
            try{
                System.out.print("\nEnter: ");
                enter = sc.nextInt();
                System.out.println();

                switch (enter){
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        Dealership.getAllVehicles(vehicle);
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest(vehicle);
                        break;
                    case 10:
                        Main.getRecords();
                        break;
                    case 11:
                        ContractDataManager.saleLease();
                        break;
                    case 99:
                        System.exit(0);
                    default:
                        System.out.println("\nEnter a number between 1 and 9 only.\n99 to Exit.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError ! Invalid Input !");
                sc.nextLine();
            }
        }





    }
//    public static void saleLease() {
//
//
//
//    }

    public static void processGetByPriceRequest() {
//        System.out.println("\nEnter minimum Price: ");
//        double min = sc.nextDouble();
//        System.out.println("\nEnter maximum Price: ");
//        double max = sc.nextDouble();
        System.out.println("Not Added yet");



    }
    public static void processGetByMakeModelRequest() {
        System.out.println("Not Added yet");
    }
    public static void processGetByYearRequest() {
        System.out.println("Not Added yet");
    }
    public static void processGetByColorRequest() {
//        System.out.print("Enter Color: ");
//        String color = scanner.nextLine();
//        List<Vehicle> results = dealership.getVehiclesByColor(color);
//        displayVehicles(results);
        System.out.println("Not Added yet");

    }
    public static void processGetByMileageRequest() {
        System.out.println("Not Added yet");
    }
    public static void processGetByVehicleTypeRequest() {
        System.out.println("Not Added yet");
    }
    public static void processAllVehiclesRequest() {
        System.out.println("Not Added yet");
    }
    public static void processAddVehicleRequest() {
        System.out.println("Not Added yet");
    }
    public static void processRemoveVehicleRequest(List<Vehicle> vehicle) {
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        dealership.removeVehicle(vehicle,vin);

//        DealershipFileManager dfm = new DealershipFileManager();
//        dfm.saveDealership(dealership);
        DealershipFileManager d = new DealershipFileManager();
        d.saveDealership(dealership);

        System.out.println("\nVehicle removed successfully!");

    }
}
