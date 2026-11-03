package exercise1;

/**
 * Driver demonstrating generic containers (Box, Pair) and generic array methods without type casts.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("  Practical 13 - Exercise 1: Generic Containers (Box<T>, Pair<A, B>)");
        System.out.println("  Student: Krupal Parmar | ID: 25CS057 | University: CHARUSAT (DEPSTAR)");
        System.out.println("======================================================================\n");

        // 1. Box<T> demonstrations with distinct types
        System.out.println("--- 1. Generic Box<T> Type Safety (No Downcasting Required) ---");

        Box<String> stringBox = new Box<>("DEPSTAR CHARUSAT");
        String strVal = stringBox.get(); // Directly returns String without (String) cast
        System.out.printf("  String Box : %s | Extracted value length: %d chars%n",
                stringBox, strVal.length());

        Box<Integer> integerBox = new Box<>(25057);
        Integer intVal = integerBox.get(); // Directly returns Integer without (Integer) cast
        System.out.printf("  Integer Box: %s | Extracted value squared: %d%n",
                integerBox, (intVal * intVal));

        Box<Double> doubleBox = new Box<>(3.92);
        Double dblVal = doubleBox.get();
        System.out.printf("  Double Box : %s | Extracted value percentage: %.2f%%%n",
                doubleBox, (dblVal * 25.0));

        // 2. Pair<A, B> demonstrations with heterogeneous types
        System.out.println("\n--- 2. Generic Heterogeneous Pair<A, B> ---");

        Pair<String, Integer> studentAge = new Pair<>("Krupal Parmar", 19);
        System.out.printf("  Student Pair: %s | First: '%s', Second: %d%n",
                studentAge, studentAge.getFirst(), studentAge.getSecond());

        Pair<Integer, Double> scorePercent = new Pair<>(98, 98.5);
        System.out.printf("  Score Pair  : %s | First: %d, Second: %.1f%n",
                scorePercent, scorePercent.getFirst(), scorePercent.getSecond());

        Pair<String, String> credPair = new Pair<>("25CS057", "Computer Science");
        System.out.printf("  ID/Branch   : %s | ID: %s, Dept: %s%n",
                credPair, credPair.getFirst(), credPair.getSecond());

        // 3. Generic method getFirstElement(E[] array)
        System.out.println("\n--- 3. Generic Method: <E> E getFirstElement(E[] array) ---");

        String[] fruits = {"Apple", "Banana", "Cherry", "Date"};
        String firstFruit = ArrayUtils.getFirstElement(fruits);
        System.out.printf("  String Array Input : [Apple, Banana, Cherry, Date]%n");
        System.out.printf("  First Element (E=String)  : '%s' (Type: %s)%n",
                firstFruit, firstFruit.getClass().getSimpleName());

        Integer[] primes = {2, 3, 5, 7, 11, 13};
        Integer firstPrime = ArrayUtils.getFirstElement(primes);
        System.out.printf("  Integer Array Input: [2, 3, 5, 7, 11, 13]%n");
        System.out.printf("  First Element (E=Integer) : %d (Type: %s)%n",
                firstPrime, firstPrime.getClass().getSimpleName());

        Double[] metrics = {3.14159, 2.71828, 1.61803};
        Double firstMetric = ArrayUtils.getFirstElement(metrics);
        System.out.printf("  Double Array Input : [3.14159, 2.71828, 1.61803]%n");
        System.out.printf("  First Element (E=Double)  : %.5f (Type: %s)%n",
                firstMetric, firstMetric.getClass().getSimpleName());

        System.out.println("\n----------------------------------------------------------------------");
        System.out.println("  Generics Type-Safety Verification Summary");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("  1. Strong Type Checking : CONFIRMED (Zero explicit runtime type casts used)");
        System.out.println("  2. Heterogeneous Pairs  : CONFIRMED (Type parameters decoupled successfully)");
        System.out.println("  3. Generic Method Reuse : CONFIRMED (Method operates uniformly on any array type)");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("  Final Status : SUCCESS (Generic Containers & Type Safety Verified)");
        System.out.println("======================================================================");
    }
}

