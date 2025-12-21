// Program to calculate bonus for employee, manager and executive

class Employee {

    int salary;

    Employee(int s) {
        salary = s;
    }

    int bonus() {
        return (int)(0.10 * salary);
    }
}

class Manager extends Employee {

    Manager(int s) {
        super(s);
    }

    int bonus() {
        return (int)(0.25 * salary) + 5000;
    }
}

class Executive extends Manager {

    Executive(int s) {
        super(s);
    }

    int bonus() {
        return (int)(0.50 * salary) + 10000;
    }
}

class q5 {

    static int totalBonus(Employee arr[]) {

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i].bonus();
        }

        return sum;
    }

    public static void main(String args[]) {

        Employee e = new Employee(100000);
        Employee m = new Manager(100000);
        Employee exe = new Executive(200000);

        Employee list[] = { e, m, exe };

        System.out.println("Employee bonus = " + e.bonus());
        System.out.println("Manager bonus = " + m.bonus());
        System.out.println("Executive bonus = " + exe.bonus());

        System.out.println("Total bonus = " + totalBonus(list));
    }
}
