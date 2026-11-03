package exercise1;

/**
 * Generic single-item container providing strong compile-time type safety without casting.
 *
 * @param <T> the type of value stored in this box
 * @author Krupal Parmar (25CS057)
 */
public class Box<T> {
    private T value;

    public Box() {
        this.value = null;
    }

    public Box(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return value == null;
    }

    @Override
    public String toString() {
        return String.format("Box<%s> [value=%s]",
                (value != null ? value.getClass().getSimpleName() : "Empty"), value);
    }
}

