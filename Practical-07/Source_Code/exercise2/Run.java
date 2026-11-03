package exercise2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation marking no-arg methods to be executed by MiniTestRunner.
 * Demonstrates the reflective foundation of test frameworks like JUnit.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Run {
    String description() default "";
}

