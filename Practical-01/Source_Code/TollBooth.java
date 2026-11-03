/**
 * Practical 01 - Exercise 2
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Problem Statement:
 * 2. Toll booth (TollBooth.java, main in this file)
 * (a) Define a record Vehicle(String number, String type).
 * (b) In main, keep a running toll total and three counters (bike, car, truck).
 * (c) Loop until the user types "done" for the number: build a Vehicle, use a switch
 *     expression on its type for the toll (bike->20, car->50, truck->150), add to the total,
 *     and increment that type's counter.
 * (d) After the loop, print the total toll and the type with the highest count.
 * Expected output: two cars + one bike -> "Total toll: 120", "Most frequent: car".
 */

import java.util.Scanner;

// (a) Define a record Vehicle(String number, String type)
record Vehicle(String number, String type) {
}

public class TollBooth {
    public static void main(String[] args) {
        // (b) In main, keep a running toll total and three counters (bike, car, truck)
        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Highway Toll Booth ===");
        System.out.println("Enter vehicle details (or type 'done' as number to finish)");

        // (c) Loop until user types "done" for vehicle number
        while (true) {
            System.out.print("Enter vehicle number (or 'done'): ");
            String number = scanner.next().trim();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type (bike/car/truck): ");
            String type = scanner.next().trim().toLowerCase();

            // Build a Vehicle record instance
            Vehicle vehicle = new Vehicle(number, type);

            // Switch expression on vehicle type for toll calculation
            int toll;
            switch (vehicle.type()) {
                case "bike" -> {
                    toll = 20;
                    bikeCount++;
                }
                case "car" -> {
                    toll = 50;
                    carCount++;
                }
                case "truck" -> {
                    toll = 150;
                    truckCount++;
                }
                default -> {
                    System.out.println("Unknown vehicle type: '" + vehicle.type() + "'. Toll not collected.");
                    continue;
                }
            }

            totalToll += toll;
            System.out.println("Processed " + vehicle + " | Toll: " + toll + " | Running Total: " + totalToll);
        }

        // (d) After the loop, print the total toll and the type with the highest count
        System.out.println("\n=== Toll Collection Summary ===");
        System.out.println("Total toll: " + totalToll);
        System.out.println("Counts -> Bike: " + bikeCount + ", Car: " + carCount + ", Truck: " + truckCount);

        String mostFrequent;
        if (bikeCount == 0 && carCount == 0 && truckCount == 0) {
            mostFrequent = "none";
        } else if (bikeCount > carCount && bikeCount > truckCount) {
            mostFrequent = "bike";
        } else if (carCount > bikeCount && carCount > truckCount) {
            mostFrequent = "car";
        } else if (truckCount > bikeCount && truckCount > carCount) {
            mostFrequent = "truck";
        } else {
            // In case of a tie between highest counts
            int max = Math.max(bikeCount, Math.max(carCount, truckCount));
            StringBuilder ties = new StringBuilder();
            if (bikeCount == max) ties.append("bike ");
            if (carCount == max) ties.append("car ");
            if (truckCount == max) ties.append("truck ");
            mostFrequent = ties.toString().trim() + " (tie)";
        }

        System.out.println("Most frequent: " + mostFrequent);

        scanner.close();
    }
}

