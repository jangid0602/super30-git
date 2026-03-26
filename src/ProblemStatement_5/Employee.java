package ProblemStatement_5;

public class Employee {
    String name;
    int id;
    protected int baseSalary;

    Employee(String name, int id, int baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    int getBonus() {
        return baseSalary * 10 / 100;
    }
}
