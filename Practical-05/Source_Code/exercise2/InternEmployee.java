package exercise2;

public class InternEmployee extends Employee {
    private final double stipend;

    public InternEmployee(String id, String name, double stipend) {
        super(id, name);
        this.stipend = stipend;
    }

    public double getStipend() {
        return stipend;
    }

    @Override
    public double monthlySalary() {
        return stipend;
    }

    @Override
    public String getEmployeeType() {
        return "Intern";
    }
}

