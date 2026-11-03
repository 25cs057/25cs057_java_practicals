package exercise1;

import java.util.List;

/**
 * Practical 04 - Exercise 1 (Driver)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * (c) In Driver.main: test several passwords; for each, print which rules passed
 *     and the final label.
 * Expected output: "abc" -> Weak; "Abcd1234!" -> Strong.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Practical 04 - Exercise 1: Password Strength Evaluator ===");

        String[] testPasswords = new String[] {
            "abc",          // 0 rules passed -> Weak
            "password",     // 1 rule passed (length >= 8) -> Weak
            "Password12",   // 3 rules passed (length, upper, digit) -> Medium
            "Abcd1234!"     // 4 rules passed (all) -> Strong
        };

        for (String pw : testPasswords) {
            List<String> passed = PasswordChecker.getPassedRules(pw);
            String label = PasswordChecker.strength(pw);

            System.out.println("\nPassword: \"" + pw + "\"");
            System.out.println("  Passed Rules (" + passed.size() + "/4):");
            if (passed.isEmpty()) {
                System.out.println("    (None)");
            } else {
                for (String rule : passed) {
                    System.out.println("    [OK] " + rule);
                }
            }
            System.out.println("  Strength Label -> " + label);
        }
    }
}

