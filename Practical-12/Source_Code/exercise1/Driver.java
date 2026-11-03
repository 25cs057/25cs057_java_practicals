package exercise1;

import java.util.List;
import java.util.Map;

/**
 * Driver demonstrating HashMap frequency counting and Comparator-based sorting.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Driver {
    private static final String SAMPLE_PARAGRAPH =
            "Java collections provide powerful data structures. The Java Collections Framework " +
            "includes list, set, and map implementations. A map stores key-value pairs while " +
            "a set stores unique elements. Java developers frequently use a hashmap because " +
            "a hashmap offers fast constant-time performance for key lookup operations. Java is robust!";

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("  Practical 12 - Exercise 1: Word Frequency Counter (HashMap & Comparator)");
        System.out.println("  Student: Krupal Parmar | ID: 25CS057 | University: CHARUSAT (DEPSTAR)");
        System.out.println("======================================================================\n");

        System.out.println("--- Input Paragraph ---");
        System.out.println("\"" + SAMPLE_PARAGRAPH + "\"\n");

        // 1. Count frequencies using HashMap
        Map<String, Integer> freqMap = WordFrequencyCounter.countFrequencies(SAMPLE_PARAGRAPH);
        System.out.printf("Total Distinct Words Extracted: %d%n%n", freqMap.size());

        // 2. Sort entries using Comparator
        List<Map.Entry<String, Integer>> sortedEntries = WordFrequencyCounter.sortByFrequency(freqMap);

        System.out.println("--- Word Frequencies Sorted by Occurrence (Highest First) ---");
        System.out.printf("%-6s | %-16s | %-12s%n", "Rank", "Word", "Occurrences");
        System.out.println("----------------------------------------------------------------------");

        int rank = 1;
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.printf("#%-5d | %-16s | %4d times%n", rank++, entry.getKey(), entry.getValue());
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.println("  Verification Summary");
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("  Highest Frequency Word : '%s' (%d occurrences)%n",
                sortedEntries.get(0).getKey(), sortedEntries.get(0).getValue());
        System.out.printf("  Total Distinct Terms   : %d%n", sortedEntries.size());

        // Verify descending order
        boolean isSorted = true;
        for (int i = 0; i < sortedEntries.size() - 1; i++) {
            if (sortedEntries.get(i).getValue() < sortedEntries.get(i + 1).getValue()) {
                isSorted = false;
                break;
            }
        }
        System.out.printf("  Comparator Order Check : %s%n",
                isSorted ? "SUCCESS (Strictly sorted highest to lowest frequency)" : "FAIL");
        System.out.println("======================================================================");
    }
}

