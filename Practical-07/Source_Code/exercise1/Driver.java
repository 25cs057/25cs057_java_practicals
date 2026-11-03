package exercise1;

import java.util.List;

/**
 * Practical 07 - Exercise 1 (Driver)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Problem Statement:
 * Form validator: define @NotBlank and @MaxLength(int) for fields and annotate a
 * SignupForm. Write a checker that uses reflection to read each field's annotations
 * and returns the list of validation errors for a given object.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Practical 07 - Exercise 1: Reflection Form Validator ===");

        // Test Case 1: Valid SignupForm
        System.out.println("\n--- Test Case 1: Valid Signup Form ---");
        SignupForm validForm = new SignupForm("krupal_p", "pass123", "krupal@example.com");
        List<String> errors1 = FormValidator.validate(validForm);
        if (errors1.isEmpty()) {
            System.out.println("Validation Passed: No errors detected in validForm.");
        } else {
            System.out.println("Validation Failed with errors: " + errors1);
        }

        // Test Case 2: Invalid SignupForm (blank username, overly long password, null email)
        System.out.println("\n--- Test Case 2: Invalid Signup Form with Multiple Violations ---");
        SignupForm invalidForm = new SignupForm("  ", "supersecretpasswordtoolong", null);
        List<String> errors2 = FormValidator.validate(invalidForm);

        System.out.println("Validation Status: FAILED (" + errors2.size() + " errors detected)");
        for (int i = 0; i < errors2.size(); i++) {
            System.out.println("  " + (i + 1) + ". [VIOLATION] " + errors2.get(i));
        }
    }
}

