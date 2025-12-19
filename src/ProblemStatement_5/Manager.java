package ProblemStatement_5;

public class Manager extends Employee {

    Manager(String name, int id, int baseSalary) {
        super(name, id, baseSalary);
    }

    int getBonus() {
        return baseSalary * 25 / 100 + 5000;
    }
}
