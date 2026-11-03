package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Reflective test runner discovering and executing @Test methods.
 *
 * @author Krupal Parmar (25CS057)
 */
public class TestRunner {

    public static void runTests(Class<?> testClass) {
        System.out.println("======================================================================");
        System.out.println("  Practical 14 - Automated Unit Test Runner (JUnit Pattern)");
        System.out.println("  Test Class: " + testClass.getSimpleName());
        System.out.println("======================================================================\n");

        Method[] methods = testClass.getDeclaredMethods();
        List<Method> testMethods = new ArrayList<>();

        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                testMethods.add(m);
            }
        }

        System.out.printf("Discovered %d test methods annotated with @Test.%n%n", testMethods.size());

        int passed = 0;
        int failed = 0;

        for (Method testMethod : testMethods) {
            Test annotation = testMethod.getAnnotation(Test.class);
            String desc = annotation.description().isEmpty() ? testMethod.getName() : annotation.description();

            System.out.printf("RUNNING: %-35s - %s%n", testMethod.getName() + "()", desc);

            try {
                Object instance = testClass.getDeclaredConstructor().newInstance();
                testMethod.invoke(instance);
                System.out.println("  --> RESULT: [PASS] Checked successfully.\n");
                passed++;
            } catch (InvocationTargetException e) {
                System.err.println("  --> RESULT: [FAIL] " + e.getCause().getMessage() + "\n");
                failed++;
            } catch (Exception e) {
                System.err.println("  --> RESULT: [ERROR] Setup failure: " + e.getMessage() + "\n");
                failed++;
            }
        }

        System.out.println("----------------------------------------------------------------------");
        System.out.println("  Unit Test Execution Summary");
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("  Tests Discovered : %d%n", testMethods.size());
        System.out.printf("  Tests Passed     : %d%n", passed);
        System.out.printf("  Tests Failed     : %d%n", failed);
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("  Overall Result   : %s%n",
                (failed == 0) ? "ALL TESTS PASSED (100% Quality & Verification Passed)" : "TEST FAILURES DETECTED");
        System.out.println("======================================================================\n");
    }

    public static void main(String[] args) {
        runTests(ItemServiceTest.class);
    }
}

