package exercise2;

public class FullTimeEmployee extends Employee {
    private final double fixedMonthlySalary;

    public FullTimeEmployee(String id, String name, double fixedMonthlySalary) {
        super(id, name);
        this.fixedMonthlySalary = fixedMonthlySalary;
    }

    @Override
    public double monthlySalary() {
        return fixedMonthlySalary;
    }

    @Override
    public String getEmployeeType() {
        return "Full-Time";
    }
}

