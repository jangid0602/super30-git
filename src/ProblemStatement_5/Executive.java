package ProblemStatement_5;

public class Executive extends Manager {

    Executive(String name, int id, int baseSalary) {
        super(name, id, baseSalary);
    }

    int getBonus() {
        return baseSalary * 50 / 100 + 10000;
    }
}