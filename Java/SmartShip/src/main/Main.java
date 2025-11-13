package main;

import model.*;
import service.*;
import exception.*;

public class Main {
    public static void main(String[] args) {
        DeliveryImplementation manager = new DeliveryImplementation();

        manager.addAgent(new Agent("Amit", "Delhi", 2));
        manager.addAgent(new Agent("Raj", "Delhi", 2));
        manager.addAgent(new Agent("Sneha", "Mumbai", 1));

        PackageInfo p1 = new PackageInfo("P1", "Delhi", true);
        PackageInfo p2 = new PackageInfo("P2", "Delhi", false);
        PackageInfo p3 = new PackageInfo("P3", "Mumbai", true);

        try {
            manager.assignPackage(p1);
            manager.assignPackage(p2);
            manager.assignPackage(p3);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        manager.printStatus();
    }
}
