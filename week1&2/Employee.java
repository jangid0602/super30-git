import java.util.*;

// Base class
public class Employee {
    protected double baseSalary;

    Employee(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    double calculateBonus() {
        return 0.10 * baseSalary;
    }
}


