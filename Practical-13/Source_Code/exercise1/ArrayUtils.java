package exercise1;

/**
 * Utility class providing generic array operations with compile-time type inference.
 *
 * @author Krupal Parmar (25CS057)
 */
public class ArrayUtils {

    /**
     * Generic method returning the first element of any non-empty array of type E.
     *
     * @param <E>   the component type of the array
     * @param array the input array
     * @return the first element, or null if the array is null or empty
     */
    public static <E> E getFirstElement(E[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[0];
    }
}

