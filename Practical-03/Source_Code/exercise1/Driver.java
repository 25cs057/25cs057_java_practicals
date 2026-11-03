package exercise1;

/**
 * Practical 03 - Exercise 1 (Driver)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * (d) In Driver.main: build a Point[] with some repeated coordinates.
 * (e) Count distinct points: for each point, use equals() to check whether it already
 *     appeared earlier; count those that did not.
 * (f) Print "Distinct: N".
 * Expected output: 5 points with 2 repeats -> "Distinct: 3".
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Practical 03 - Exercise 1: Distinct Points ===");

        // (d) Build a Point[] with 5 points and 2 repeats
        Point[] points = new Point[] {
            new Point(2, 3),
            new Point(5, 7),
            new Point(2, 3),  // Repeat of index 0
            new Point(8, 1),
            new Point(5, 7)   // Repeat of index 1
        };

        System.out.println("Input Points Array (Size: " + points.length + "):");
        for (int i = 0; i < points.length; i++) {
            System.out.println("  Index " + i + ": " + points[i]);
        }

        // (e) Count distinct points using equals() against all previous elements
        int distinctCount = 0;
        System.out.println("\nChecking uniqueness:");
        for (int i = 0; i < points.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (points[i].equals(points[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                distinctCount++;
                System.out.println("  " + points[i] + " -> Unique distinct point (#" + distinctCount + ")");
            } else {
                System.out.println("  " + points[i] + " -> Duplicate skipped");
            }
        }

        // (f) Print distinct count
        System.out.println("\nSummary:");
        System.out.println("Distinct: " + distinctCount);
    }
}

