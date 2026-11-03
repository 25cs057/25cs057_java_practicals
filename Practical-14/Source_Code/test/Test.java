package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom runtime annotation marking unit test methods in compliance with the JUnit test pattern.
 *
 * @author Krupal Parmar (25CS057)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
    String description() default "";
}

