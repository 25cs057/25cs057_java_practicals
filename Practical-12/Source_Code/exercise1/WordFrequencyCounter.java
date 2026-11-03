package exercise1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Word frequency analyzer using HashMap and custom Comparator sorting.
 *
 * @author Krupal Parmar (25CS057)
 */
public class WordFrequencyCounter {

    /**
     * Splits a text paragraph into words and accumulates counts in a HashMap.
     */
    public static Map<String, Integer> countFrequencies(String paragraph) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return frequencyMap;
        }

        // Clean punctuation and tokenize words
        String cleaned = paragraph.replaceAll("[^a-zA-Z0-9\\s]", " ").toLowerCase();
        String[] tokens = cleaned.split("\\s+");

        for (String token : tokens) {
            String word = token.trim();
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        return frequencyMap;
    }

    /**
     * Sorts Map entries by frequency descending (highest count first);
     * ties are broken alphabetically by word in ascending order.
     */
    public static List<Map.Entry<String, Integer>> sortByFrequency(Map<String, Integer> frequencyMap) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        Comparator<Map.Entry<String, Integer>> frequencyComparator = (e1, e2) -> {
            int countComparison = e2.getValue().compareTo(e1.getValue()); // Descending
            if (countComparison != 0) {
                return countComparison;
            }
            return e1.getKey().compareTo(e2.getKey()); // Ascending alphabetical tie-break
        };

        entryList.sort(frequencyComparator);
        return entryList;
    }
}

