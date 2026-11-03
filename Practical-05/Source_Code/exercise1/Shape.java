package exercise1;

/**
 * Practical 05 - Exercise 1 (Abstract Shape)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * An abstract Shape base class with abstract area() method.
 */
public abstract class Shape {
    private final String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method to be implemented by all concrete shapes
    public abstract double area();

    @Override
    public String toString() {
        return String.format("%s (Area: %.2f)", name, area());
    }
}

