package exercise2;

/**
 * Practical 05 - Exercise 2 (Driver)
 * Student Name: Krupal Parmar
 * Student ID: 25CS057
 * Course: CEUE203 - Object-Oriented Programming
 *
 * Problem Statement:
 * Payroll: an abstract Employee with abstract monthlySalary(); FullTime (fixed),
 * PartTime (hours * rate) and Intern (stipend), each calling super for the shared
 * name/id. Loop a mixed array to print each salary and the total; use instanceof
 * to add a note only for interns.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("=== Practical 05 - Exercise 2: Polymorphic Payroll System ===");

        // Mixed polymorphic array of Employee references
        Employee[] employees = new Employee[] {
            new FullTimeEmployee("EMP001", "Aarav Sharma", 75000.0),
            new PartTimeEmployee("EMP002", "Diya Patel", 80.0, 450.0), // 80 hrs * 450 = 36000
            new InternEmployee("EMP003", "Karan Dave", 18000.0),
            new FullTimeEmployee("EMP004", "Sneha Joshi", 62000.0),
            new InternEmployee("EMP005", "Pooja Mehta", 18000.0)
        };

        double totalPayroll = 0.0;

        System.out.println("Monthly Payroll Disbursement:");
        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            double salary = emp.monthlySalary(); // Dynamic method dispatch
            totalPayroll += salary;

            System.out.printf("  [%d] ID: %s | Name: %-14s | Type: %-9s | Salary: ₹%,9.2f",
                    (i + 1), emp.getId(), emp.getName(), emp.getEmployeeType(), salary);

            // Use instanceof to add a note only for interns
            if (emp instanceof InternEmployee) {
                System.out.print("  <-- [NOTE: Eligible for full-time conversion evaluation]");
            }
            System.out.println();
        }

        System.out.println("\n--- Payroll Summary ---");
        System.out.printf("Total Organization Monthly Payroll: ₹%,.2f%n", totalPayroll);
    }
}

