import java.util.Scanner;

// Main class
public class CompanyBonusSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nEmployee " + (i + 1));
            System.out.println("1. Employee");
            System.out.println("2. Manager");
            System.out.println("3. Executive");
            System.out.print("Choose role: ");
            int choice = sc.nextInt();

            System.out.print("Enter base salary: ");
            double salary = sc.nextDouble();

            Employee emp;

            if (choice == 1) {
                emp = new Employee(salary);
            } else if (choice == 2) {
                emp = new Manager(salary);
            } else {
                emp = new Executive(salary);
            }

            double bonus = emp.calculateBonus();
            totalBonus += bonus;

            System.out.println("Bonus = ₹" + bonus);
        }

        System.out.println("\nTotal Company Bonus Payout = ₹" + totalBonus);
        sc.close();
    }
}
