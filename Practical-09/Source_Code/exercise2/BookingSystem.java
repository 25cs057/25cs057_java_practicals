package exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Shared seat booking system demonstrating ticket oversell race condition and synchronized resolution.
 *
 * @author Krupal Parmar (25CS057)
 */
public class BookingSystem {
    private int seatsLeft;
    private final int totalCapacity;
    private final List<String> successfulBookings = Collections.synchronizedList(new ArrayList<>());
    private final List<String> rejectedBookings = Collections.synchronizedList(new ArrayList<>());

    public BookingSystem(int totalCapacity) {
        this.totalCapacity = totalCapacity;
        this.seatsLeft = totalCapacity;
    }

    /**
     * Unsynchronized booking method exhibiting a classic Check-Then-Act race condition.
     * Multiple concurrent threads read seatsLeft > 0 simultaneously before any thread can decrement it,
     * leading to overselling beyond actual capacity.
     */
    public boolean bookSeatUnsynchronized(String passengerName) {
        if (seatsLeft > 0) {
            try {
                // Simulate processing latency to reliably expose race condition
                Thread.sleep(15);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            seatsLeft--;
            successfulBookings.add(passengerName);
            System.out.printf("  [UNSYNC] %-15s successfully booked a seat! (Seats left recorded: %d)%n",
                    passengerName, seatsLeft);
            return true;
        } else {
            rejectedBookings.add(passengerName);
            System.out.printf("  [UNSYNC] %-15s booking REJECTED (House Full)%n", passengerName);
            return false;
        }
    }

    /**
     * Synchronized booking method providing atomic mutual exclusion.
     * Only one thread at a time can inspect and decrement seatsLeft,
     * strictly preventing overselling.
     */
    public synchronized boolean bookSeatSynchronized(String passengerName) {
        if (seatsLeft > 0) {
            try {
                // Simulate processing latency inside protected critical section
                Thread.sleep(15);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            seatsLeft--;
            successfulBookings.add(passengerName);
            System.out.printf("  [SYNC]   %-15s successfully booked a seat! (Seats left remaining: %d)%n",
                    passengerName, seatsLeft);
            return true;
        } else {
            rejectedBookings.add(passengerName);
            System.out.printf("  [SYNC]   %-15s booking REJECTED (House Full)%n", passengerName);
            return false;
        }
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public List<String> getSuccessfulBookings() {
        return Collections.unmodifiableList(successfulBookings);
    }

    public List<String> getRejectedBookings() {
        return Collections.unmodifiableList(rejectedBookings);
    }

    public void reset() {
        this.seatsLeft = totalCapacity;
        this.successfulBookings.clear();
        this.rejectedBookings.clear();
    }
}

