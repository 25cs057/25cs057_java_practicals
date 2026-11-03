package exercise1;

import java.util.Scanner;

/**
 * Practical 08 - Exercise 1 (Driver)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Problem Statement:
 * Guarded calculator: read two numbers and an operator; throw a custom DivideByZeroException
 * and catch invalid-number input separately, printing a clear message each time; loop until
 * a valid calculation succeeds and use finally to log each attempt.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Practical 08 - Exercise 1: Guarded Calculator ===");
        Scanner scanner = new Scanner(System.in);
        int attempt = 0;
        boolean success = false;

        while (!success) {
            attempt++;
            System.out.println("\n--- Calculation Attempt #" + attempt + " ---");

            try {
                System.out.print("Enter calculation (format: <num1> <operator> <num2>): ");
                if (!scanner.hasNextLine()) {
                    break;
                }
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+");
                if (parts.length < 3) {
                    throw new IllegalArgumentException("Incomplete expression. Expected: <number1> <operator> <number2>");
                }

                double a = Double.parseDouble(parts[0]);
                String op = parts[1];
                double b = Double.parseDouble(parts[2]);

                double result = GuardedCalculator.calculate(a, b, op);
                System.out.printf("SUCCESS: %.2f %s %.2f = %.2f%n", a, op, b, result);
                success = true;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR - Invalid Input] Non-numeric input encountered: " + e.getMessage());
            } catch (DivideByZeroException e) {
                System.out.println("[ERROR - Custom Exception] " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR - Invalid Operation] " + e.getMessage());
            } finally {
                System.out.println("  [FINALLY LOG] Finished processing Attempt #" + attempt +
                        " | Status: " + (success ? "SUCCEEDED" : "FAILED / RETRYING"));
            }
        }

        System.out.println("\nCalculator session terminated.");
        scanner.close();
    }
}
