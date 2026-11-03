package exercise2;

/**
 * Practical 07 - Exercise 2 (Driver)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Problem Statement:
 * Mini test runner: define a @Run annotation and mark some no-arg methods of a class
 * with it. Use reflection to find and invoke only the @Run methods and report how many
 * ran - the idea behind how JUnit finds @Test methods.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Practical 07 - Exercise 2: Reflection Mini Test Runner ===");

        int executedCount = MiniTestRunner.runTests(SampleTestSuite.class);

        System.out.println("\n--- Test Execution Summary ---");
        System.out.println("Total @Run test methods executed: " + executedCount);
    }
}

