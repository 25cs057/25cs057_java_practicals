package exercise1;

import java.util.ArrayList;
import java.util.List;

/**
 * Practical 04 - Exercise 1
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * (a) In PasswordChecker, check four rules:
 *     1. length >= 8
 *     2. contains an uppercase letter (regex ".*[A-Z].*")
 *     3. contains a digit (regex ".*[0-9].*")
 *     4. contains a special character (regex ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")
 * (b) Write strength(String pw) that counts how many rules pass and returns:
 *     "Weak" (0-1), "Medium" (2-3) or "Strong" (4).
 */
public class PasswordChecker {

    public static List<String> getPassedRules(String pw) {
        List<String> passed = new ArrayList<>();
        if (pw == null) return passed;

        // Rule 1: Length >= 8
        if (pw.length() >= 8) {
            passed.add("Length >= 8");
        }
        // Rule 2: Contains uppercase letter
        if (pw.matches(".*[A-Z].*")) {
            passed.add("Contains Uppercase Letter");
        }
        // Rule 3: Contains digit
        if (pw.matches(".*[0-9].*")) {
            passed.add("Contains Digit");
        }
        // Rule 4: Contains special character
        if (pw.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            passed.add("Contains Special Character");
        }

        return passed;
    }

    public static String strength(String pw) {
        int passedCount = getPassedRules(pw).size();

        // Weak (0-1), Medium (2-3), Strong (4)
        if (passedCount <= 1) {
            return "Weak";
        } else if (passedCount <= 3) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

