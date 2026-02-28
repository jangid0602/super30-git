//The Corporate Hierarcy System

import java.util.ArrayList;


class Employee {
    protected double baseSalary;

    public Employee(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    
    public double calculateBonus() {
        return baseSalary * 0.10;
    }
}


class Manager extends Employee {

    public Manager(double baseSalary) {
        super(baseSalary);
    }

    
    @Override
    public double calculateBonus() {
        return baseSalary * 0.25 + 5000;
    }
}
class Executive extends Manager {

    public Executive(double baseSalary) {
        super(baseSalary);
    }

    
    @Override
    public double calculateBonus() {
        return baseSalary * 0.50 + 10000;
    }
}


public class Week4_Task5 {

    
    public static double getTotalBonus(ArrayList<Employee> employees) {
        double total = 0;

        for (Employee e : employees) {
            total += e.calculateBonus();
        }
        return total;
    }

    public static void main(String[] args) {

        
        Employee e = new Employee(100000);
        Manager m = new Manager(100000);

        ArrayList<Employee> list1 = new ArrayList<>();
        list1.add(e);
        list1.add(m);

        System.out.println(getTotalBonus(list1)); // 40000

        
        Executive ex = new Executive(200000);
        ArrayList<Employee> list2 = new ArrayList<>();
        list2.add(ex);

        System.out.println(getTotalBonus(list2)); // 110000

        
        ArrayList<Employee> list3 = new ArrayList<>();
        list3.add(e);
        list3.add(m);
        list3.add(ex);

        System.out.println(getTotalBonus(list3));
    }
}