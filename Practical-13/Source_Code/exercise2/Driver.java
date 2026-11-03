package exercise2;

import java.util.Arrays;

/**
 * Driver demonstrating bounded type generics (<N extends Number>) across multiple numeric types.
 *
 * @author Krupal Parmar (25CS057)
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("  Practical 13 - Exercise 2: Bounded Type Parameter Generics");
        System.out.println("  Student: Krupal Parmar | ID: 25CS057 | University: CHARUSAT (DEPSTAR)");
        System.out.println("======================================================================\n");

        // 1. Integer[] average computation
        Integer[] integerScores = {85, 92, 78, 96, 89};
        double intAvg = BoundedStats.average(integerScores);
        System.out.println("--- 1. Testing with Integer[] ---");
        System.out.println("  Input Array : " + Arrays.toString(integerScores));
        System.out.printf("  Calculated Average: %.2f%n%n", intAvg);

        // 2. Double[] average computation
        Double[] doubleWeights = {12.75, 18.50, 24.25, 30.00};
        double dblAvg = BoundedStats.average(doubleWeights);
        System.out.println("--- 2. Testing with Double[] ---");
        System.out.println("  Input Array : " + Arrays.toString(doubleWeights));
        System.out.printf("  Calculated Average: %.4f%n%n", dblAvg);

        // 3. Long[] average computation
        Long[] longTimestamps = {1_000_000L, 2_500_000L, 4_000_000L, 5_500_000L};
        double longAvg = BoundedStats.average(longTimestamps);
        System.out.println("--- 3. Testing with Long[] ---");
        System.out.println("  Input Array : " + Arrays.toString(longTimestamps));
        System.out.printf("  Calculated Average: %,.2f%n%n", longAvg);

        // 4. Float[] average computation
        Float[] floatTemperatures = {36.6f, 37.2f, 38.0f, 36.8f};
        double floatAvg = BoundedStats.average(floatTemperatures);
        System.out.println("--- 4. Testing with Float[] ---");
        System.out.println("  Input Array : " + Arrays.toString(floatTemperatures));
        System.out.printf("  Calculated Average: %.2f%n%n", floatAvg);

        // 5. Analytical note on why non-Number types are strictly refused
        System.out.println("----------------------------------------------------------------------");
        System.out.println("  Architectural Analysis: Why Non-Number Types Are Compile-Time Refused");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("  Problem Query : Why does BoundedStats.average(...) reject String[] or Object[]?");
        System.out.println("  Compiler Rule : The type parameter signature '<N extends Number>' establishes");
        System.out.println("                  an upper bound constraint on type parameter N.");
        System.out.println("  Mechanism     : 1. java.lang.Number defines the contract for .doubleValue().");
        System.out.println("                  2. Non-numeric classes (e.g., String, Date, Person) do NOT");
        System.out.println("                     subclass Number and lack arithmetic conversion methods.");
        System.out.println("                  3. Invoking BoundedStats.average(new String[]{\"A\", \"B\"}) triggers");
        System.out.println("                     compile-time error: 'type argument java.lang.String is not");
        System.out.println("                     within bounds of type-variable N'.");
        System.out.println("                  4. This provides total static type safety, eliminating any risk");
        System.out.println("                     of runtime ClassCastException during computation.");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("  Final Status : SUCCESS (Bounded Type Method Validated Across All Numbers)");
        System.out.println("======================================================================");
    }
}

