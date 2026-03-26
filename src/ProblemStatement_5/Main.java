package ProblemStatement_5;

public class Main {
        static int totalBonus(Employee[] arr) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum = sum + arr[i].getBonus();
            }
            return sum;
        }

        public static void main(String[] args) {

            Employee e = new Employee("A", 1, 100000);
            Manager m = new Manager("B", 2, 100000);
            Executive x = new Executive("C", 3, 200000);

            Employee[] list1 = {e, m};
            System.out.println(totalBonus(list1));

            Employee[] list2 = {x};
            System.out.println(totalBonus(list2));

            Employee[] list3 = {e, m, x};
            System.out.println(totalBonus(list3));
        }
}
