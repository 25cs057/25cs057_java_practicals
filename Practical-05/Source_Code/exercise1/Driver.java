package exercise1;

/**
 * Practical 05 - Exercise 1 (Driver)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Problem Statement:
 * Shape areas: an abstract Shape with abstract area(); subclasses Circle, Rectangle,
 * Triangle. Put a mix in a Shape[] and loop once to print each area and the running
 * total, tracking the largest - one loop handling every shape through polymorphism.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Practical 05 - Exercise 1: Polymorphic Shape Areas ===");

        // Put a mix of shapes into a polymorphic Shape[] array
        Shape[] shapes = new Shape[] {
            new Circle(4.0),           // Area: PI * 16 ≈ 50.27
            new Rectangle(5.0, 8.0),   // Area: 40.00
            new Triangle(6.0, 7.0),    // Area: 21.00
            new Circle(2.5),           // Area: PI * 6.25 ≈ 19.63
            new Rectangle(7.0, 9.0)    // Area: 63.00 (Largest)
        };

        double runningTotal = 0.0;
        Shape largestShape = null;
        double maxArea = -1.0;

        System.out.println("Processing Shapes Array (One polymorphic loop):");
        for (int i = 0; i < shapes.length; i++) {
            Shape s = shapes[i];
            double a = s.area(); // Dynamic method dispatch (polymorphism)
            runningTotal += a;

            if (a > maxArea) {
                maxArea = a;
                largestShape = s;
            }

            System.out.printf("  [%d] %-10s | Calculated Area: %8.2f | Running Total: %8.2f%n",
                    (i + 1), s.getName(), a, runningTotal);
        }

        System.out.println("\n--- Summary ---");
        System.out.printf("Total Area of all shapes : %.2f%n", runningTotal);
        if (largestShape != null) {
            System.out.printf("Largest Shape            : %s with area %.2f%n",
                    largestShape.getName(), largestShape.area());
        }
    }
}

