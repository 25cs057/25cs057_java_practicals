package exercise2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Reflection-driven test execution engine that discovers and invokes @Run methods.
 */
public class MiniTestRunner {

    public static int runTests(Class<?> testClass) {
        System.out.println("MiniTestRunner scanning class: " + testClass.getName());
        int count = 0;

        try {
            Object instance = testClass.getDeclaredConstructor().newInstance();
            Method[] methods = testClass.getDeclaredMethods();

            for (Method method : methods) {
                // Check if the method is annotated with @Run
                if (method.isAnnotationPresent(Run.class)) {
                    Run runAnnotation = method.getAnnotation(Run.class);
                    String desc = runAnnotation.description().isEmpty() ? "" : " - " + runAnnotation.description();

                    // Ensure the method takes no arguments
                    if (method.getParameterCount() == 0) {
                        System.out.println("  -> Discovered test method: " + method.getName() + "()" + desc);
                        method.setAccessible(true);
                        method.invoke(instance);
                        count++;
                    } else {
                        System.out.println("  [WARNING] Skipping @Run method " + method.getName() + ": requires parameters.");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error while instantiating or invoking test class: " + e.getMessage());
        }

        return count;
    }
}

