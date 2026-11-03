package exercise2;

/**
 * Utility class providing bounded type generic methods for numerical computations.
 *
 * @author Krupal Parmar (25CS057)
 */
public class BoundedStats {

    /**
     * Calculates the arithmetic mean across any array of numerical types.
     * The bounded type parameter <N extends Number> guarantees that every element
     * has access to the doubleValue() method defined in java.lang.Number.
     *
     * @param <N>    a type that is a subclass of java.lang.Number
     * @param values input array of numerical values
     * @return the arithmetic average as a double
     * @throws IllegalArgumentException if values is null or empty
     */
    public static <N extends Number> double average(N[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty for average computation!");
        }

        double sum = 0.0;
        for (N val : values) {
            if (val != null) {
                sum += val.doubleValue();
            }
        }
        return sum / values.length;
    }
}

