/**
 * Practical 02 - Exercise 2
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Problem Statement:
 * 2. Cinema show (CinemaShow.java, main in this file)
 * (a) Create class CinemaShow with private String title, private int seatsAvailable,
 *     private final int capacity, and private static int totalBooked=0.
 * (b) Constructor(title, capacity): set both and seatsAvailable = capacity.
 *     Constructor(title): chain with this(title, 100).
 * (c) book(int n): if n <= seatsAvailable, reduce seatsAvailable by n, add n to totalBooked,
 *     return true; else return false unchanged.
 * (d) cancel(int n): increase seatsAvailable by n but never above capacity.
 * (e) Add getSeatsAvailable() and static getTotalBooked().
 * (f) In main: run a sequence of book and cancel calls, printing the result and seats
 *     after each, then print getTotalBooked().
 * Expected output: booking more than available prints false and leaves seats unchanged;
 * totalBooked equals the successful bookings.
 */

public class CinemaShow {
    // (a) Private fields, final capacity, and static counter
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    // (b) Constructor(title, capacity)
    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    // Constructor(title) chained with this(title, 100)
    public CinemaShow(String title) {
        this(title, 100);
    }

    // (c) book(int n): book seats if available, increment totalBooked, return true; else return false
    public boolean book(int n) {
        if (n <= 0) {
            System.out.println("Booking count must be positive.");
            return false;
        }
        if (n <= this.seatsAvailable) {
            this.seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

    // (d) cancel(int n): increase seatsAvailable by n but never above capacity
    public void cancel(int n) {
        if (n <= 0) {
            System.out.println("Cancellation count must be positive.");
            return;
        }
        this.seatsAvailable = Math.min(this.capacity, this.seatsAvailable + n);
    }

    // (e) Getters
    public int getSeatsAvailable() {
        return this.seatsAvailable;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getTitle() {
        return this.title;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    // (f) In main: run a sequence of book and cancel calls, printing the result and seats after each
    public static void main(String[] args) {
        System.out.println("=== Cinema Show Booking System ===");

        // Create CinemaShow instances: one with explicit capacity, one with default chained capacity 100
        CinemaShow morningShow = new CinemaShow("Inception", 50);
        CinemaShow eveningShow = new CinemaShow("Interstellar"); // default capacity 100

        System.out.println("Show 1: " + morningShow.getTitle() + " | Capacity: " + morningShow.getCapacity() + " | Available: " + morningShow.getSeatsAvailable());
        System.out.println("Show 2: " + eveningShow.getTitle() + " | Capacity: " + eveningShow.getCapacity() + " | Available: " + eveningShow.getSeatsAvailable());

        System.out.println("\n--- Performing Transactions on '" + morningShow.getTitle() + "' ---");

        // Action 1: Book 30 seats (should succeed)
        boolean res1 = morningShow.book(30);
        System.out.println("Booking 30 seats -> Result: " + res1 + " | Seats Available: " + morningShow.getSeatsAvailable());

        // Action 2: Book 25 seats (only 20 left, should fail and return false with seats unchanged)
        boolean res2 = morningShow.book(25);
        System.out.println("Booking 25 seats -> Result: " + res2 + " | Seats Available: " + morningShow.getSeatsAvailable());

        // Action 3: Book 15 seats (should succeed)
        boolean res3 = morningShow.book(15);
        System.out.println("Booking 15 seats -> Result: " + res3 + " | Seats Available: " + morningShow.getSeatsAvailable());

        // Action 4: Cancel 10 seats (should increase seats available)
        System.out.println("Cancelling 10 seats...");
        morningShow.cancel(10);
        System.out.println("After cancellation -> Seats Available: " + morningShow.getSeatsAvailable());

        // Action 5: Try to cancel 100 seats (should never exceed capacity 50)
        System.out.println("Cancelling 100 seats (boundary check against capacity)...");
        morningShow.cancel(100);
        System.out.println("After over-cancellation -> Seats Available: " + morningShow.getSeatsAvailable() + " (Capacity: " + morningShow.getCapacity() + ")");

        System.out.println("\n--- System Summary ---");
        System.out.println("Total Booked across all shows: " + CinemaShow.getTotalBooked());
    }
}
