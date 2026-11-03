package exercise1;

import java.util.Objects;

/**
 * Practical 03 - Exercise 1
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * (a) Create class Point with private int x, y and a constructor.
 * (b) Override toString() to return "(x, y)".
 * (c) Override equals(Object) to be true when both x and y match, and hashCode() to agree.
 */
public class Point {
    // (a) Private coordinates
    private final int x;
    private final int y;

    // Constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // (b) Override toString() to return "(x, y)"
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // (c) Override equals(Object) to be true when both x and y match
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    // hashCode() agreeing with equals()
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

