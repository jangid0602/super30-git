import java.util.Scanner;

// Manager class
class Manager extends Employee {

    Manager(double baseSalary) {
        super(baseSalary);
    }

    @Override
    double calculateBonus() {
        return (0.25 * baseSalary) + 5000;
    }
}