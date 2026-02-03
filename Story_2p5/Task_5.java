package Codeup.Story_2p5;

import java.util.Scanner;

public class Task_5 {
    static class Employee {
        protected double baseSalary;
        Employee(double baseSalary) { this.baseSalary = baseSalary; }
        double calculateBonus() { return 0.10 * baseSalary; }
    }

    static class Manager extends Employee {
        Manager(double baseSalary) { super(baseSalary); }
        double calculateBonus() { return 0.25 * baseSalary + 5000; }
    }

    static class Executive extends Manager {
        Executive(double baseSalary) { super(baseSalary); }
        double calculateBonus() { return 0.50 * baseSalary + 10000; }
    }

    public double totalBonus(Employee[] emp) {
        double sum = 0;
        for (int i = 0; i < emp.length; i++)
            sum += emp[i].calculateBonus();
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task_5 m = new Task_5();
        System.out.print("Enter number of employees: ");
        int c = sc.nextInt();
        Employee[] emp = new Employee[c];
        for (int i = 0; i < c; i++) {
            System.out.print("Enter type (1-Employee,2-Manager,3-Executive): ");
            int type = sc.nextInt();
            System.out.print("Enter base salary: ");
            double sal = sc.nextDouble();
            if (type == 1) emp[i] = new Employee(sal);
            else if (type == 2) emp[i] = new Manager(sal);
            else emp[i] = new Executive(sal);
        }
        System.out.println(m.totalBonus(emp));

    }
}
