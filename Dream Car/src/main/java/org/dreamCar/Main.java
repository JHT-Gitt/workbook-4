package org.dreamCar;

import org.dreamCar.data.DealershipFileManager;
import org.dreamCar.model.Vehicle;
import org.dreamCar.ui.UserInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    //File file = new File("src/main/java/org/dreamCar/data/inventory.csv");

        List<Vehicle> vehicle = DealershipFileManager.getDealership("src/main/java/org/dreamCar/data/inventory.csv");

        
        UserInterface.display(vehicle);


    }
    public static void getRecords(){
        List<String[]> records = new ArrayList<>();
        String filePath = "src/main/java/org/dreamCar/contract/contracts.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\|");
                records.add(fields);
            }
//            for (String[] row : records) {
//                System.out.println(Arrays.toString(row));
//                for( String field : row){
//                    System.out.printf("%-10s\n", field);
//                }
//            }
            for (String[] row : records) {
                if (row.length > 0 && (row[0].equalsIgnoreCase("SALE") || row[0].equalsIgnoreCase("LEASE"))) {
                    for (String field : row) {
                        System.out.printf("%-5s - ", field);
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            //
        }
    }
}