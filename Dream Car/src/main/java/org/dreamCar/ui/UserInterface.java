package org.dreamCar.ui;

import org.dreamCar.model.Dealership;
import org.dreamCar.model.Vehicle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static Scanner sc = new Scanner(System.in);
    public static List<Dealership> dealership = new ArrayList<>();

 //   public UserInterface() {
      //  dealership = new DealershipFileManager().getDealership();
 //   }

    public static void display(List<Vehicle> vehicle) {
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
        System.out.println(" 99 - Quit");

        while(true){
            try{
                System.out.print("\nEnter: ");
                enter = sc.nextInt();

                switch (enter){
                    case 1:

                    case 2:
                    case 3:
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                    case 6:
                    case 7:
                        Dealership.getAllVehicles(vehicle);
                        break;
                    case 8:
                    case 9:
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

    public static void processGetByPriceRequest() {
        System.out.println("\nEnter minimum Price: ");
        double min = sc.nextDouble();
        System.out.println("\nEnter maximum Price: ");
        double max = sc.nextDouble();



    }
    public void processGetByMakeModelRequest() {}
    public void processGetByYearRequest() {}
    public static void processGetByColorRequest() {
        System.out.print("\nEnter color: ");
        String colorSearch = sc.next();

        Dealership.getVehiclesByColor(colorSearch);

    }
    public void processGetByMileageRequest() {}
    public void processGetByVehicleTypeRequest() {}
    public void processAllVehiclesRequest() {}
    public void processAddVehicleRequest() {}
    public void processRemoveVehicleRequest() {}
}
