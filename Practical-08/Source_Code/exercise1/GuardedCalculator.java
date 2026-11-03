package exercise1;

public class GuardedCalculator {

    public static double calculate(double a, double b, String operator) throws DivideByZeroException {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (Math.abs(b) < 1e-9) {
                    throw new DivideByZeroException("Arithmetic Error: Division by zero is undefined.");
                }
                yield a / b;
            }
            case "%" -> {
                if (Math.abs(b) < 1e-9) {
                    throw new DivideByZeroException("Arithmetic Error: Modulo by zero is undefined.");
                }
                yield a % b;
            }
            default -> throw new IllegalArgumentException("Unknown operator '" + operator + "'. Supported: +, -, *, /, %");
        };
    }
}

