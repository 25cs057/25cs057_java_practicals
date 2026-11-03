package exercise2;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver demonstrating race condition in seat booking and resolution via synchronization.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Driver {
    private static final int TOTAL_SEATS = 5;
    private static final int PASSENGER_COUNT = 10;

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("  Practical 09 - Exercise 2: Shared Seat Booking Race Condition");
        System.out.println("  Student: Krupal Parmar | ID: 25CS057 | University: CHARUSAT (DEPSTAR)");
        System.out.println("======================================================================\n");

        BookingSystem cinemaHall = new BookingSystem(TOTAL_SEATS);

        // --------------------------------------------------------------------
        // Phase 1: Unsynchronized Booking (Demonstrating Overselling)
        // --------------------------------------------------------------------
        System.out.println("--- Phase 1: Unsynchronized Booking (Vulnerable to Overselling) ---");
        System.out.printf("Initial Available Seats : %d%n", cinemaHall.getSeatsLeft());
        System.out.printf("Simultaneous Passengers : %d%n", PASSENGER_COUNT);
        System.out.println("Launching concurrent booking threads...\n");

        List<Thread> unsyncThreads = new ArrayList<>();
        for (int i = 1; i <= PASSENGER_COUNT; i++) {
            final String passenger = "Passenger-" + i;
            Thread t = new Thread(() -> cinemaHall.bookSeatUnsynchronized(passenger), passenger);
            unsyncThreads.add(t);
        }

        // Start all threads concurrently
        for (Thread t : unsyncThreads) {
            t.start();
        }

        for (Thread t : unsyncThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\nUnsynchronized Booking Run Summary:");
        System.out.printf("  Total Initial Seats Available: %d%n", cinemaHall.getTotalCapacity());
        System.out.printf("  Successful Bookings Count    : %d%n", cinemaHall.getSuccessfulBookings().size());
        System.out.printf("  Final Recorded Seats Left    : %d%n", cinemaHall.getSeatsLeft());
        if (cinemaHall.getSuccessfulBookings().size() > TOTAL_SEATS) {
            int oversold = cinemaHall.getSuccessfulBookings().size() - TOTAL_SEATS;
            System.out.printf("  ALERT: OVERSELL DETECTED! %d extra ticket(s) issued due to race condition!%n%n", oversold);
        } else {
            System.out.println("  Result: No oversell occurred in this scheduling slice.\n");
        }

        // --------------------------------------------------------------------
        // Phase 2: Synchronized Booking (Thread-Safe Critical Section)
        // --------------------------------------------------------------------
        System.out.println("--- Phase 2: Synchronized Booking (Thread-Safe Critical Section) ---");
        cinemaHall.reset();
        System.out.printf("System reset. Initial Available Seats: %d%n", cinemaHall.getSeatsLeft());
        System.out.printf("Simultaneous Passengers: %d%n", PASSENGER_COUNT);
        System.out.println("Launching concurrent synchronized booking threads...\n");

        List<Thread> syncThreads = new ArrayList<>();
        for (int i = 1; i <= PASSENGER_COUNT; i++) {
            final String passenger = "Passenger-" + i;
            Thread t = new Thread(() -> cinemaHall.bookSeatSynchronized(passenger), passenger);
            syncThreads.add(t);
        }

        for (Thread t : syncThreads) {
            t.start();
        }

        for (Thread t : syncThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\nSynchronized Booking Run Summary:");
        System.out.printf("  Total Initial Seats Available: %d%n", cinemaHall.getTotalCapacity());
        System.out.printf("  Successful Bookings Count    : %d%n", cinemaHall.getSuccessfulBookings().size());
        System.out.printf("  Rejected Bookings Count      : %d%n", cinemaHall.getRejectedBookings().size());
        System.out.printf("  Final Recorded Seats Left    : %d%n", cinemaHall.getSeatsLeft());
        System.out.printf("  Result: %s%n",
                (cinemaHall.getSuccessfulBookings().size() == TOTAL_SEATS && cinemaHall.getSeatsLeft() == 0)
                        ? "SUCCESS (Exactly 5 seats booked, zero overselling! Mutual exclusion verified)"
                        : "FAIL");
        System.out.println("======================================================================");
    }
}

