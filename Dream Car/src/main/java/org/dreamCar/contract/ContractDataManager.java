package org.dreamCar.contract;

import org.dreamCar.model.Vehicle;
import org.w3c.dom.ls.LSOutput;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
//import static org.dreamCar.contract.SalesContract;

import static org.dreamCar.data.DealershipFileManager.scanner;

public class ContractDataManager {

    public static List<Vehicle> inventory = new ArrayList<>();

   public static ArrayList<SalesContract> sales = new ArrayList<>();

   static String choice;
    static String date;
    static String name;
    static String email;
    static String isFinance;
    static int vin;

         public static String saleLease(){


             System.out.println("\n S - Sell   L - Lease");
             System.out.print("Enter type of Contract: ");
             choice = scanner.next();
             if (choice.equalsIgnoreCase("s")){
                 choice = "SALE";
                 sale();

             }else if(choice.equalsIgnoreCase("l")){
                 choice = "LEASE";
                 lease();
             }
            // System.out.println(choice);

             return choice;
         }

        public static void sale(){


           for(Vehicle v : inventory){
               int vh = v.getVin();
           }

            System.out.println(choice);
            System.out.print("\nEnter Vehicle VIN : ");
            vin = scanner.nextInt();
            System.out.print("Enter date of contract (yyyy-mm-dd) : ");
            date = scanner.next();
            System.out.print("Enter Customer name : ");
            name = scanner.next();
            System.out.print("Enter Customer email : ");
            email = scanner.next();
            System.out.print("Do you want to finance [Y/N]: ");
            isFinance = scanner.next();

            if(isFinance.equalsIgnoreCase("n")){
                isFinance = "NO";
            }else if(isFinance.equalsIgnoreCase("y")){

            }








        }
        public static void lease(){
            System.out.println(choice);


        }








}
