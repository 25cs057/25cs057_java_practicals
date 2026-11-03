package exercise2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Visitor tracker comparing HashSet deduplication with LinkedHashSet insertion-order retention.
 *
 * @author Krupal Parmar (25CS057)
 */
public class VisitorTracker {

    /**
     * Deduplicates login entries using HashSet (fast, unordered hash bucket storage).
     */
    public static Set<String> countUniqueUsers(List<String> rawLogins) {
        return new HashSet<>(rawLogins);
    }

    /**
     * Deduplicates login entries using LinkedHashSet (preserves exact first-seen insertion order).
     */
    public static Set<String> getFirstSeenUniqueUsers(List<String> rawLogins) {
        return new LinkedHashSet<>(rawLogins);
    }

    /**
     * Extracts the first N distinct users based on insertion order.
     */
    public static List<String> getFirstNDistinct(Set<String> orderedSet, int count) {
        List<String> result = new ArrayList<>();
        int index = 0;
        for (String user : orderedSet) {
            if (index++ < count) {
                result.add(user);
            } else {
                break;
            }
        }
        return result;
    }
}

