package exercise2;

import java.util.Scanner;

/**
 * Practical 04 - Exercise 2 (Driver)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * (a) In Driver.main, define a String[] of log lines like "10:05 alice Hello there"
 *     (include one malformed line with fewer than 3 parts).
 * (b) Read a keyword from the user.
 * (c) For each line, split into time/user/message with split(" ", 3); skip lines
 *     that do not have 3 parts.
 * (d) If the message contains the keyword (case-insensitive), increment a counter
 *     and append "time user: message" to a StringBuilder.
 * (e) Print "Matches: N" and the built report.
 * Expected output: keyword "hello" over 3 lines (1 malformed) -> "Matches: 1"
 * and the matching line.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Practical 04 - Exercise 2: Chat-Log Filter ===");

        // (a) Define a String[] of 3 log lines (including one malformed line)
        String[] logs = new String[] {
            "10:05 alice Hello there",
            "10:06 bob",                    // Malformed line (fewer than 3 parts)
            "10:07 charlie Good morning all"
        };

        System.out.println("Available Chat Logs:");
        for (String log : logs) {
            System.out.println("  " + log);
        }

        // (b) Read keyword from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter keyword to filter: ");
        String keyword = scanner.hasNext() ? scanner.next().trim() : "hello";

        System.out.println("Searching for: \"" + keyword + "\"...\n");

        // Filter and build report
        ChatFilter.FilterResult result = ChatFilter.filterLogs(logs, keyword);

        // (e) Print Matches count and built report
        System.out.println("Matches: " + result.getMatchCount());
        if (result.getMatchCount() > 0) {
            System.out.print(result.getReport());
        }

        scanner.close();
    }
}
