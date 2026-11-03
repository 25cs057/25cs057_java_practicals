package exercise2;

/**
 * Practical 05 - Exercise 2 (Abstract Employee)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Abstract base class representing an employee in the payroll system.
 */
public abstract class Employee {
    private final String id;
    private final String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Abstract method to be overridden by each employee subtype
    public abstract double monthlySalary();

    public abstract String getEmployeeType();
}

