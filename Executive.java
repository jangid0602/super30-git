import java.util.Scanner;

// Executive class
class Executive extends Manager {

    Executive(double baseSalary) {
        super(baseSalary);
    }

    @Override
    double calculateBonus() {
        return (0.50 * baseSalary) + 10000;
    }
}
