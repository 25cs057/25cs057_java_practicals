package exercise2;

/**
 * Practical 06 - Exercise 2
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Functional Interface representing an outbound communication notifier.
 */
@FunctionalInterface
public interface Notifier {
    void send(String message);
}

