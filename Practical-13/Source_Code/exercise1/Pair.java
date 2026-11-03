package exercise1;

/**
 * Generic two-element heterogeneous tuple container.
 *
 * @param <A> the type of the first element
 * @param <B> the type of the second element
 * @author Krupal Parmar (25CS057)
 */
public class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return String.format("Pair<%s, %s> (%s, %s)",
                (first != null ? first.getClass().getSimpleName() : "null"),
                (second != null ? second.getClass().getSimpleName() : "null"),
                first, second);
    }
}

