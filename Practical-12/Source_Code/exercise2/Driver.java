package exercise2;

import java.util.List;
import java.util.Set;

/**
 * Driver demonstrating HashSet uniqueness verification and LinkedHashSet first-seen ordering.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Driver {
    private static final List<String> RAW_LOGINS = List.of(
            "kparmar",
            "alice_w",
            "bob_builder",
            "kparmar",      // Duplicate #1
            "charlie_dev",
            "alice_w",      // Duplicate #2
            "diana_prince",
            "kparmar",      // Duplicate #3
            "edward_snow",
            "bob_builder",  // Duplicate #4
            "frank_castle",
            "alice_w"       // Duplicate #5
    );

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("  Practical 12 - Exercise 2: Unique Visitors (HashSet vs LinkedHashSet)");
        System.out.println("  Student: Krupal Parmar | ID: 25CS057 | University: CHARUSAT (DEPSTAR)");
        System.out.println("======================================================================\n");

        System.out.println("--- 1. Raw Login Access Sequence (With Repeats) ---");
        System.out.println("Total raw login events recorded: " + RAW_LOGINS.size());
        for (int i = 0; i < RAW_LOGINS.size(); i++) {
            System.out.printf("  Event #%02d: %s%n", (i + 1), RAW_LOGINS.get(i));
        }

        // 2. Count unique users using HashSet
        Set<String> hashSetUsers = VisitorTracker.countUniqueUsers(RAW_LOGINS);
        System.out.println("\n--- 2. Unordered Deduplication via HashSet ---");
        System.out.printf("Unique Visitor Count (HashSet.size()): %d%n", hashSetUsers.size());
        System.out.println("HashSet Elements (Hash bucket order): " + hashSetUsers);

        // 3. Preserve first-seen order using LinkedHashSet
        Set<String> linkedSetUsers = VisitorTracker.getFirstSeenUniqueUsers(RAW_LOGINS);
        System.out.println("\n--- 3. Insertion-Order Retention via LinkedHashSet ---");
        System.out.printf("Unique Visitor Count (LinkedHashSet.size()): %d%n", linkedSetUsers.size());
        System.out.println("LinkedHashSet Elements (First-seen order) : " + linkedSetUsers);

        // 4. Retrieve the first three distinct names
        List<String> firstThree = VisitorTracker.getFirstNDistinct(linkedSetUsers, 3);
        System.out.println("\n--- 4. First Three Distinct Visitors (First-Seen Order) ---");
        for (int i = 0; i < firstThree.size(); i++) {
            System.out.printf("  #%d: %s%n", (i + 1), firstThree.get(i));
        }

        System.out.println("\n----------------------------------------------------------------------");
        System.out.println("  Verification Summary");
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("  Total Raw Login Events      : %d%n", RAW_LOGINS.size());
        System.out.printf("  Unique Users Verified       : %d distinct users%n", hashSetUsers.size());
        System.out.printf("  Duplicates Eliminated       : %d redundant events%n",
                RAW_LOGINS.size() - hashSetUsers.size());
        System.out.printf("  First 3 Distinct Names List : %s%n", firstThree);
        System.out.printf("  First 3 Expected Match      : %s%n",
                firstThree.equals(List.of("kparmar", "alice_w", "bob_builder"))
                        ? "CONFIRMED (Exact first-seen sequence verified)"
                        : "FAIL");
        System.out.println("======================================================================");
    }
}

