package org.dreamCar;

import org.dreamCar.data.DealershipFileManager;
import org.dreamCar.model.Vehicle;
import org.dreamCar.ui.UserInterface;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    //File file = new File("src/main/java/org/dreamCar/data/inventory.csv");




        List<Vehicle> vehicle = DealershipFileManager.getDealership("src/main/java/org/dreamCar/data/inventory.csv");

        UserInterface.display(vehicle);

    }
}