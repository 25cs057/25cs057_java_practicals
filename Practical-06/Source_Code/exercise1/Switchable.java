package exercise1;

/**
 * Practical 06 - Exercise 1 (Switchable Interface)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Interface with on(), off(), state checking, and a default toggle() method.
 */
public interface Switchable {
    void on();
    void off();
    boolean isOn();
    String getName();

    // Default method to toggle state
    default void toggle() {
        if (isOn()) {
            off();
        } else {
            on();
        }
    }
}

