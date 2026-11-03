package exercise1;

/**
 * Practical 06 - Exercise 1 (Driver)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Problem Statement:
 * Remote control: an interface Switchable with on()/off() and a default toggle();
 * Fan and Light implement it. Loop over a Switchable[] toggling each. Then add a
 * functional interface that decides, given a device and an hour, whether it may
 * switch on, and supply it once as an anonymous class and once as a lambda.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Practical 06 - Exercise 1: Remote Control Devices ===");

        Switchable[] devices = new Switchable[] {
            new Light("Study Desk Lamp"),
            new Fan("Ceiling Fan"),
            new Light("Corridor Night Light")
        };

        System.out.println("\n--- Step 1: Looping over Switchable[] and Toggling Each ---");
        for (Switchable dev : devices) {
            System.out.println("Device: " + dev.getName() + " | Initial State: " + (dev.isOn() ? "ON" : "OFF"));
            System.out.println("Executing default toggle():");
            dev.toggle(); // Calls default method in interface
            System.out.println("New State: " + (dev.isOn() ? "ON" : "OFF") + "\n");
        }

        System.out.println("--- Step 2: Supplying Functional Interface via Anonymous Class ---");
        // Anonymous class implementation: Evening lighting rule (allow Lights between 18:00 and 23:00)
        DeviceScheduler eveningLightRule = new DeviceScheduler() {
            @Override
            public boolean canSwitchOn(Switchable device, int hour) {
                if (device instanceof Light) {
                    return hour >= 18 && hour <= 23;
                }
                return true; // Other devices unrestricted
            }
        };

        int testHour1 = 20; // 8 PM
        int testHour2 = 14; // 2 PM
        System.out.println("Evening Lighting Rule (Anonymous Class):");
        System.out.println("  Can '" + devices[0].getName() + "' switch on at " + testHour1 + ":00? -> " +
                eveningLightRule.canSwitchOn(devices[0], testHour1));
        System.out.println("  Can '" + devices[0].getName() + "' switch on at " + testHour2 + ":00? -> " +
                eveningLightRule.canSwitchOn(devices[0], testHour2));

        System.out.println("\n--- Step 3: Supplying Functional Interface via Lambda Expression ---");
        // Lambda implementation: Energy saver cooling rule (allow Fans only between 11:00 and 17:00)
        DeviceScheduler energySaverFanRule = (device, hour) -> {
            if (device instanceof Fan) {
                return hour >= 11 && hour <= 17;
            }
            return true;
        };

        int testHour3 = 13; // 1 PM
        int testHour4 = 22; // 10 PM
        System.out.println("Energy Saver Fan Rule (Lambda Expression):");
        System.out.println("  Can '" + devices[1].getName() + "' switch on at " + testHour3 + ":00? -> " +
                energySaverFanRule.canSwitchOn(devices[1], testHour3));
        System.out.println("  Can '" + devices[1].getName() + "' switch on at " + testHour4 + ":00? -> " +
                energySaverFanRule.canSwitchOn(devices[1], testHour4));
    }
}

