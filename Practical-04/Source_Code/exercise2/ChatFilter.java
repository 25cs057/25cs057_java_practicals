package exercise2;

/**
 * Practical 04 - Exercise 2 (ChatFilter Utility)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Provides filtering and string parsing routines for chat log lines.
 */
public class ChatFilter {

    public static class FilterResult {
        private final int matchCount;
        private final String report;

        public FilterResult(int matchCount, String report) {
            this.matchCount = matchCount;
            this.report = report;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public String getReport() {
            return report;
        }
    }

    /**
     * Filters log lines based on a search keyword (case-insensitive).
     * Format per line: "time user message"
     * Appends to StringBuilder in format: "time user: message"
     */
    public static FilterResult filterLogs(String[] lines, String keyword) {
        StringBuilder sb = new StringBuilder();
        int matches = 0;
        String lowerKeyword = keyword.toLowerCase();

        for (String line : lines) {
            if (line == null) continue;

            // (c) Split into time, user, and message using split(" ", 3)
            String[] parts = line.split(" ", 3);

            // Skip lines that do not have 3 parts (malformed)
            if (parts.length < 3) {
                continue;
            }

            String time = parts[0];
            String user = parts[1];
            String message = parts[2];

            // (d) Check if message contains keyword (case-insensitive)
            if (message.toLowerCase().contains(lowerKeyword)) {
                matches++;
                sb.append(time).append(" ").append(user).append(": ").append(message).append("\n");
            }
        }

        return new FilterResult(matches, sb.toString());
    }
}

