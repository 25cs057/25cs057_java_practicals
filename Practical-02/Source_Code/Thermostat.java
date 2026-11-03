/**
 * Practical 02 - Exercise 1
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Problem Statement:
 * 1. Smart thermostat (Thermostat.java, main in this file)
 * (a) Create class Thermostat with private String location, private int temperature,
 *     private static final int MIN=16 and MAX=30, and private static int activeCount=0.
 * (b) Constructor(location, startTemp): store location; set temperature to startTemp
 *     if it is within MIN..MAX else 22; increment activeCount.
 * (c) Constructor(location): chain with this(location, 22).
 * (d) raise(): if temperature < MAX add 1, else print "Already at maximum (30)".
 * (e) lower(): if temperature > MIN subtract 1, else print "Already at minimum (16)".
 * (f) Add getTemperature() (no setter) and static getActiveCount().
 * (g) In main: create two thermostats, call raise() 10 times then lower() 20 times
 *     in loops (printing the temperature each time), then print getActiveCount().
 * Expected output: temperature rises to 30 then "Already at maximum", falls to 16
 * then "Already at minimum", count 2.
 */

public class Thermostat {
    // (a) Private fields, constants, and static counter
    private String location;
    private int temperature;
    private static final int MIN = 16;
    private static final int MAX = 30;
    private static int activeCount = 0;

    // (b) Constructor(location, startTemp)
    public Thermostat(String location, int startTemp) {
        this.location = location;
        if (startTemp >= MIN && startTemp <= MAX) {
            this.temperature = startTemp;
        } else {
            this.temperature = 22; // default safe fallback
        }
        activeCount++;
    }

    // (c) Constructor(location) chained with this(location, 22)
    public Thermostat(String location) {
        this(location, 22);
    }

    // (d) raise(): increment temperature or report maximum reached
    public void raise() {
        if (this.temperature < MAX) {
            this.temperature++;
        } else {
            System.out.println("Already at maximum (" + MAX + ")");
        }
    }

    // (e) lower(): decrement temperature or report minimum reached
    public void lower() {
        if (this.temperature > MIN) {
            this.temperature--;
        } else {
            System.out.println("Already at minimum (" + MIN + ")");
        }
    }

    // (f) Getter for temperature (no setter provided to preserve encapsulation)
    public int getTemperature() {
        return this.temperature;
    }

    public String getLocation() {
        return this.location;
    }

    // Static getter for active count
    public static int getActiveCount() {
        return activeCount;
    }

    // (g) In main: create two thermostats, call raise() 10 times then lower() 20 times in loops
    public static void main(String[] args) {
        System.out.println("=== Smart Thermostat Simulation ===");

        // Creating two thermostat instances
        Thermostat livingRoom = new Thermostat("Living Room", 24);
        Thermostat bedroom = new Thermostat("Bedroom"); // uses chained constructor with default 22

        System.out.println("Created Thermostat 1: " + livingRoom.getLocation() + " (Initial Temp: " + livingRoom.getTemperature() + "°C)");
        System.out.println("Created Thermostat 2: " + bedroom.getLocation() + " (Initial Temp: " + bedroom.getTemperature() + "°C)");

        System.out.println("\n--- Testing raise() 10 times on " + livingRoom.getLocation() + " ---");
        for (int i = 1; i <= 10; i++) {
            livingRoom.raise();
            System.out.println("Step " + i + " -> Temperature: " + livingRoom.getTemperature());
        }

        System.out.println("\n--- Testing lower() 20 times on " + livingRoom.getLocation() + " ---");
        for (int i = 1; i <= 20; i++) {
            livingRoom.lower();
            System.out.println("Step " + i + " -> Temperature: " + livingRoom.getTemperature());
        }

        System.out.println("\n--- Active Thermostats Count ---");
        System.out.println("Active Count: " + Thermostat.getActiveCount());
    }
}

