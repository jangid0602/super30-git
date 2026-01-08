import java.util.*;
public class MyTasks {
    public int cosmicCourier(int[] traveltime) {
        if (traveltime.length <= 1) return traveltime[0];

        int maxdeadline = Integer.MIN_VALUE;
        int secmax = Integer.MIN_VALUE;

        for (int j : traveltime) {
            if (j > maxdeadline) {
                secmax = maxdeadline;
                maxdeadline = j;
            } else if (j > secmax && j < maxdeadline) {
                secmax = j;
            }
        }
        return (secmax == Integer.MIN_VALUE) ? maxdeadline : secmax;
    }

    static class Library {
        String[] books = new String[100];
        int count = 0;

        void addBook(String title) {
            books[count++] = title;
        }

        void searchPartial(String title) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (containsStr(books[i], title)) {
                    System.out.println("Book(\"" + books[i] + "\")");
                    found = true;
                }
            }
            if (!found) System.out.println("[]");
        }

        boolean containsStr(String a, String b) {
            for (int i = 0; i <= a.length() - b.length(); i++) {
                int j = 0;
                while (j < b.length() && a.charAt(i + j) == b.charAt(j)) j++;
                if (j == b.length()) return true;
            }
            return false;
        }
    }

    public String[] factoryFloorLogic(int[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 15 == 0) result[i] = "Hazardous";
            else if (arr[i] % 3 == 0) result[i] = "Heavy";
            else if (arr[i] % 5 == 0) result[i] = "Fragile";
            else result[i] = String.valueOf(arr[i]);
        }
        return result;
    }

    public char findExtraChar(String original, String scrambled) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < original.length(); i++) {
            char ch = original.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < scrambled.length(); i++) {
            char ch = scrambled.charAt(i);
            if (!map.containsKey(ch)) return ch;
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) < 0) return ch;
        }
        return ' ';
    }

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
        for (Employee employee : emp) sum += employee.calculateBonus();
        return sum;
    }

    public int preFixSum(int[] arr, int i, int j) {
        if (i < 0 || j >= arr.length) return 0;
        int sum = 0;
        while (i <= j) sum += arr[i++];
        return sum;
    }

    public String ticketPlat(String[][] bookings) {
        HashSet<Integer> hs = new HashSet<>();
        for (String[] booking : bookings) {
            int seat = Integer.parseInt(booking[1]);
            if (hs.contains(seat)) return booking[0];
            hs.add(seat);
        }
        return "-1";
    }

    public int calculateMaxTemp(int[] arr) {
        if (arr.length == 0) return 0;
        int max = arr[0], count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        MyTasks tasks = new MyTasks();
        TaskDetail taskDetail = new TaskDetail();
        Library lib = new Library();

        while (true) {
            try {
                System.out.println("-----Program Menu-----");
                System.out.println("1 The Cosmic Courier Challenge");
                System.out.println("2 The Digital Library System");
                System.out.println("3 The Factory Floor Robot");
                System.out.println("4 The Spy’s Cipher");
                System.out.println("5 The Corporate Hierarchy System");
                System.out.println("6 The Security Log Analyzer");
                System.out.println("7 The Concert Seat Manager");
                System.out.println("8 The Weather Station Data Aggregator");
                System.out.println("9 Exit");
                System.out.print("Select number from 1 to 9: ");

                int choice = userInput.nextInt();

                if (choice < 1 || choice > 9) {
                    System.out.println("Please enter a number between 1 and 9");
                    continue;
                }

                switch (choice) {

                    case 1:
                        System.out.println(taskDetail.getTask_1);
                        System.out.print("Enter size of list : ");
                        int listSize1 = userInput.nextInt();
                        int[] t = new int[listSize1];
                        System.out.print("Enter elements : ");
                        for (int i = 0; i < listSize1; i++) t[i] = userInput.nextInt();
                        System.out.println(tasks.cosmicCourier(t));
                        break;

                    case 2:
                        System.out.println(taskDetail.getTask_2);
                        userInput.nextLine();
                        System.out.print("How many books to add : ");
                        int listSize2 = userInput.nextInt();
                        userInput.nextLine();
                        for (int i = 0; i < listSize2; i++) {
                            String title = userInput.nextLine();
                            lib.addBook(title);
                        }
                        System.out.print("Enter search title: ");
                        String search = userInput.nextLine();
                        lib.searchPartial(search);
                        break;

                    case 3:
                        System.out.println(taskDetail.getTask_3);
                        System.out.print("Enter size of list : ");
                        int listSize3 = userInput.nextInt();
                        int[] a = new int[listSize3];
                        System.out.print("Enter elements: ");
                        for (int i = 0; i < listSize3; i++) a[i] = userInput.nextInt();
                        String[] r = tasks.factoryFloorLogic(a);
                        for (String s : r) System.out.print(s + " ");
                        System.out.println();
                        break;

                    case 4:
                        System.out.println(taskDetail.getTask_4);
                        userInput.nextLine();
                        System.out.print("Enter original data : ");
                        String original = userInput.nextLine();
                        System.out.print("Enter scrambled data: ");
                        String scrambled = userInput.nextLine();
                        System.out.println(tasks.findExtraChar(original, scrambled));
                        break;

                    case 5:
                        System.out.println(taskDetail.getTask_5);
                        System.out.print("Enter number of employees : ");
                        int numEmp = userInput.nextInt();
                        Employee[] emp = new Employee[numEmp];
                        for (int i = 0; i < numEmp; i++) {
                            System.out.print("Enter type (1-Employee,2-Manager,3-Executive): ");
                            int type = userInput.nextInt();
                            System.out.print("Enter base salary: ");
                            double sal = userInput.nextDouble();
                            if (type == 1) emp[i] = new Employee(sal);
                            else if (type == 2) emp[i] = new Manager(sal);
                            else emp[i] = new Executive(sal);
                        }
                        System.out.println(tasks.totalBonus(emp));
                        break;

                    case 6:
                        System.out.println(taskDetail.getTask_6);
                        System.out.print("Enter size of login list : ");
                        int listSize6 = userInput.nextInt();
                        int[] log = new int[listSize6];
                        System.out.print("Enter data : ");
                        for (int i = 0; i < listSize6; i++) log[i] = userInput.nextInt();
                        System.out.print("Enter i and j: ");
                        int i = userInput.nextInt();
                        int j = userInput.nextInt();
                        System.out.println(tasks.preFixSum(log, i, j));
                        break;

                    case 7:
                        System.out.println(taskDetail.getTask_7);
                        System.out.print("Enter number of bookings : ");
                        int listSize7 = userInput.nextInt();
                        String[][] b = new String[listSize7][2];
                        for (int k = 0; k < listSize7; k++) {
                            System.out.println("Enter Your Customer_Id");
                            b[k][0] = userInput.next().toUpperCase(Locale.ROOT);
                            System.out.println("Enter Your (Only Number) Seat_No.");
                            b[k][1] = userInput.next().toUpperCase(Locale.ROOT);
                            System.out.println("------------------------------");
                        }
                        System.out.println(tasks.ticketPlat(b));
                        break;

                    case 8:
                        System.out.println(taskDetail.getTask_8);
                        System.out.print("Enter size of temperature list: ");
                        int listSize8 = userInput.nextInt();
                        int[] temp = new int[listSize8];
                        System.out.print("Enter data : ");
                        for (int i2 = 0; i2 < listSize8; i2++) temp[i2] = userInput.nextInt();
                        System.out.println(tasks.calculateMaxTemp(temp));
                        break;

                    case 9:
                        System.out.print("Thank you, Have a nice day ? ");
                        return;
                }

            } catch (Exception e) {
                System.out.println("First read Problem Description carefully ");
                userInput.nextLine();
            }
        }
    }
}
