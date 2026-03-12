/* This Program perform various types of Operations like - The Cousmic Courier Challenge,  The Digital Library System, The Factory Floor robot, The Spy's Cipher, 
The Corporate Hierarchy System, The Security log analyzer, The Concert seat manager. The wheather station data Aggregator etc.
Author: Jayesh Kumar Mali
Date:- 20-12-2025
*/
import java.util.*;

public class ProgramMenu {

    //The Cosmic Courier Challenge
    public int cosmiccourier(int traveltime[]) {
        if (traveltime.length <= 1) return traveltime[0];

        int maxdeadline = Integer.MIN_VALUE;
        int secmax = Integer.MIN_VALUE;

        for (int i = 0; i < traveltime.length; i++) {
            if (traveltime[i] >= maxdeadline) {
                secmax = maxdeadline;
                maxdeadline = traveltime[i];
            } else if (traveltime[i] > secmax && traveltime[i] < maxdeadline) {
                secmax = traveltime[i];
            }
        }
        return (secmax == Integer.MIN_VALUE) ? maxdeadline : secmax;
    }

    //The Digital Library System
    static class Library {
        String[] books = new String[100];
        int count = 0;

        void addBook(String title) {
            books[count++] = title;
        }

        void searchExact(String title) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (equalsStr(books[i], title)) {
                    System.out.println("Book(\"" + books[i] + "\")");
                    found = true;
                }
            }
            if (!found) System.out.println("[]");
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

        boolean equalsStr(String a, String b) {
            if (a.length() != b.length()) return false;
            for (int i = 0; i < a.length(); i++)
                if (a.charAt(i) != b.charAt(i)) return false;
            return true;
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

    //The Factory Floor Robot
    public String[] factoryfloorlogic(int arr[]) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 15 == 0) result[i] = "Hazardous";
            else if (arr[i] % 3 == 0) result[i] = "Heavy";
            else if (arr[i] % 5 == 0) result[i] = "Fragile";
            else result[i] = String.valueOf(arr[i]);
        }
        return result;
    }

    //The Spy's Cipher
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

     //The Corporate Hierarchy System
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

    //The Security Log Analyzer
   public int prefixsum(int[] arr, int i, int j) {
    if (i < 0 || j >= arr.length || i > j) return 0;
    // create a new array
    int[] prefix = new int[arr.length];
    prefix[0] = arr[0];

    for (int k = 1; k < arr.length; k++) {
        prefix[k] = prefix[k - 1] + arr[k];
    }

    // O(1) query
    if (i == 0) return prefix[j];
    return prefix[j] - prefix[i - 1];
}

    //The Concert Seat Manager
    public String ticketplat(String[][] bookings) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < bookings.length; i++) {
            int seat = Integer.parseInt(bookings[i][1]);
            if (hs.contains(seat)) return bookings[i][0];
            hs.add(seat);
        }
        return "-1";
    }

    //The Weather Station Data Aggregator
    public int calculatemaxTemp(String arr[]) {
        if (arr.length == 0) return 0;
        int max = Integer.parseInt(arr[0]), count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (Integer.parseInt(arr[i]) > max) {
                max = Integer.parseInt(arr[i]);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProgramMenu m = new ProgramMenu();
        Library lib = new Library();

        while (true) {
            try {
                System.out.println("-----Program Menu-----");
                System.out.println("1 Cosmic Courier");
                System.out.println("2 Digital Library");
                System.out.println("3 Factory Floor");
                System.out.println("4 Spy Cipher");
                System.out.println("5 Corporate Bonus");
                System.out.println("6 Security Log");
                System.out.println("7 Concert Seat");
                System.out.println("8 Weather Station");
                System.out.println("9 Exit");
                System.out.print("Select number from 1 to 9: ");

                int ch = sc.nextInt();

                if (ch < 1 || ch > 9) {
                    System.out.println("Please enter a number between 1 and 9");
                    continue;
                }

                switch (ch) {

                    case 1:
                        System.out.print("Enter size of array: ");
                        int n1 = sc.nextInt();
                        int[] t = new int[n1];
                        System.out.print("Enter elements: ");
                        for (int i = 0; i < n1; i++) t[i] = sc.nextInt();
                        System.out.println(m.cosmiccourier(t));
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.print("How many books to add: ");
                        int nb = sc.nextInt();
                        sc.nextLine();
                        for (int i = 0; i < nb; i++) {
                            String title = sc.nextLine();
                            lib.addBook(title);
                        }
                        System.out.print("Enter search title: ");
                        String search = sc.nextLine();
                        lib.searchPartial(search);
                        break;

                    case 3:
                        System.out.print("Enter size of array: ");
                        int n3 = sc.nextInt();
                        int[] a = new int[n3];
                        System.out.print("Enter elements: ");
                        for (int i = 0; i < n3; i++) a[i] = sc.nextInt();
                        String[] r = m.factoryfloorlogic(a);
                        for (int i = 0; i < r.length; i++) System.out.print(r[i] + " ");
                        System.out.println();
                        break;

                    case 4:
                        sc.nextLine();
                        System.out.print("Enter original string: ");
                        String o = sc.nextLine();
                        System.out.print("Enter scrambled string: ");
                        String s = sc.nextLine();
                        System.out.println(m.findExtraChar(o, s));
                        break;

                    case 5:
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
                        break;

                    case 6:
                        System.out.print("Enter size of login array: ");
                        int n6 = sc.nextInt();
                        int[] log = new int[n6];
                        System.out.print("Enter elements: ");
                        for (int i = 0; i < n6; i++) log[i] = sc.nextInt();
                        System.out.print("Enter i and j: ");
                        int i = sc.nextInt();
                        int j = sc.nextInt();
                        System.out.println(m.prefixsum(log, i, j));
                        break;

                    case 7:
                        System.out.print("Enter number of bookings: ");
                        int n7 = sc.nextInt();
                        String[][] b = new String[n7][2];
                        for (int k = 0; k < n7; k++) {
                            b[k][0] = sc.next();
                            b[k][1] = sc.next();
                        }
                        System.out.println(m.ticketplat(b));
                        break;

                    case 8:
                        System.out.print("Enter size of temperature array: ");
                        int n8 = sc.nextInt();
                        String[] temp = new String[n8];
                        System.out.print("Enter elements: ");
                        for (int i2 = 0; i2 < n8; i2++) temp[i2] = sc.next();
                        System.out.println(m.calculatemaxTemp(temp));
                        break;

                    case 9:
                        return;
                }

            } catch (Exception e) {
                System.out.println("Invalid Input");
                sc.nextLine();
            }
        }
    }
}







