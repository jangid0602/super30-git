package Story2o5.java;

import java.util.Scanner;

public class Assignments {

    /**
     * 1. Cosmic Courier Challenge
     * This method finds the second largest element
     * present in the given integer array.
     */
    static int cosmicCourier(int[] arr) {

        int max = 0;
        int secondMax = 0;

        // Traverse each element of the array
        for (int i = 0; i < arr.length; i++) {

            // If current element is greater than max,
            // update secondMax and max
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }
            // If current element is between max and secondMax
            else if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }

        // Return the second largest value
        return secondMax;
    }

    /**
     * 2. Digital Library System
     * This method searches book titles based on:
     * type = 1 → Exact match
     * type = 2 → Partial (substring) match
     */
    static void digitalLibrary(String[] books, String search, int type) {

        // Iterate through each book
        for (int i = 0; i < books.length; i++) {

            // Exact match search
            if (type == 1 && books[i].equals(search)) {
                System.out.println(books[i]);
            }
            // Partial match search
            else if (type == 2 && books[i].contains(search)) {
                System.out.println(books[i]);
            }
        }
    }

    /**
     * 3. Factory Floor Robot
     * Categorizes weights based on divisibility rules:
     * - Divisible by 15 → Hazardous
     * - Divisible by 3  → Heavy
     * - Divisible by 5  → Fragile
     */
    static void factoryRobot(int[] weights) {

        // Process each weight one by one
        for (int i = 0; i < weights.length; i++) {

            if (weights[i] % 15 == 0)
                System.out.println("Hazardous");
            else if (weights[i] % 3 == 0)
                System.out.println("Heavy");
            else if (weights[i] % 5 == 0)
                System.out.println("Fragile");
            else
                System.out.println(weights[i]);
        }
    }

    /**
     * 4. Spy’s Cipher
     * Finds the extra character present in the scrambled
     * string compared to the original string.
     */
    static char spyCipher(String original, String scrambled) {

        int[] count = new int[256]; // ASCII character frequency array

        // Count frequency of characters in scrambled string
        for (int i = 0; i < scrambled.length(); i++) {
            count[scrambled.charAt(i)]++;
        }

        // Reduce frequency using original string
        for (int i = 0; i < original.length(); i++) {
            count[original.charAt(i)]--;
        }

        // Identify the character with extra count
        for (int i = 0; i < 256; i++) {
            if (count[i] == 1)
                return (char) i;
        }

        return ' ';
    }

    /**
     * -------------------------------------------------
     * 5. Corporate Hierarchy
     * -------------------------------------------------
     * Calculates bonus based on employee role:
     * 1 → Intern
     * 2 → Manager
     * 3 → Director
     *
     * @param salary Base salary
     * @param role   Employee role
     * @return Bonus amount
     */
    static double corporateHierarchy(double salary, int role) {

        if (role == 1)
            return salary * 0.10;
        else if (role == 2)
            return salary * 0.25 + 5000;
        else
            return salary * 0.50 + 10000;
    }

    /**
     * 6. Security Log Analyzer
     * Uses prefix sum technique to find sum
     * between index i and j.
     */
    static int securityLog(int[] arr, int i, int j) {

        int[] prefix = new int[arr.length];

        // Initialize prefix sum
        prefix[0] = arr[0];

        // Build prefix sum array
        for (int k = 1; k < arr.length; k++) {
            prefix[k] = prefix[k - 1] + arr[k];
        }

        // Calculate range sum
        return (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
    }

    /**
     * 7. Concert Seat Manager
     * Finds the first customer who booked
     * a duplicate seat.
     */
    static String concertSeat(String[] cust, int[] seats) {

        // Compare each seat with previous seats
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < i; j++) {
                if (seats[i] == seats[j])
                    return cust[i];
            }
        }

        return "-1";
    }

    /**
     * 8. Weather Station
     * Counts how many times a new maximum
     * temperature is recorded.
     */
    static int weatherStation(int[] temps) {

        int max = Integer.MIN_VALUE;
        int count = 0;

        // Traverse temperature readings
        for (int i = 0; i < temps.length; i++) {

            // Update max and increment count
            if (temps[i] > max) {
                max = temps[i];
                count++;
            }
        }

        return count;
    }

    /**
     * MAIN METHOD
     * Menu-driven program that executes
     * selected problem from 1 to 8.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Question (1-8): ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter number of routes: ");
                int n1 = sc.nextInt();
                int[] routes = new int[n1];
                for (int i = 0; i < n1; i++)
                    routes[i] = sc.nextInt();
                System.out.println("Second largest route: " + cosmicCourier(routes));
                break;

            case 2:
                System.out.print("Enter number of books: ");
                int n2 = sc.nextInt();
                sc.nextLine();
                String[] books = new String[n2];
                for (int i = 0; i < n2; i++)
                    books[i] = sc.nextLine();
                System.out.print("Enter search keyword: ");
                String search = sc.nextLine();
                System.out.print("Enter search type (1=Exact, 2=Contains): ");
                int type = sc.nextInt();
                digitalLibrary(books, search, type);
                break;

            case 3:
                System.out.print("Enter number of weights: ");
                int n3 = sc.nextInt();
                int[] weights = new int[n3];
                for (int i = 0; i < n3; i++)
                    weights[i] = sc.nextInt();
                factoryRobot(weights);
                break;

            case 4:
                sc.nextLine();
                System.out.print("Enter original string: ");
                String original = sc.nextLine();
                System.out.print("Enter scrambled string: ");
                String scrambled = sc.nextLine();
                System.out.println("Extra character is: " + spyCipher(original, scrambled));
                break;

            case 5:
                System.out.print("Enter salary: ");
                double salary = sc.nextDouble();
                System.out.print("Enter role (1=Intern, 2=Manager, 3=Director): ");
                int role = sc.nextInt();
                System.out.println("Bonus: " + corporateHierarchy(salary, role));
                break;

            case 6:
                System.out.print("Enter number of logins: ");
                int n6 = sc.nextInt();
                int[] logins = new int[n6];
                for (int i = 0; i < n6; i++)
                    logins[i] = sc.nextInt();
                System.out.print("Enter range i and j: ");
                int i = sc.nextInt();
                int j = sc.nextInt();
                System.out.println("Logins in range: " + securityLog(logins, i, j));
                break;

            case 7:
                System.out.print("Enter number of customers: ");
                int n7 = sc.nextInt();
                String[] cust = new String[n7];
                int[] seats = new int[n7];
                for (int k = 0; k < n7; k++) {
                    cust[k] = sc.next();
                    seats[k] = sc.nextInt();
                }
                System.out.println("Duplicate seat booked by: " + concertSeat(cust, seats));
                break;

            case 8:
                System.out.print("Enter number of temperatures: ");
                int n8 = sc.nextInt();
                int[] temps = new int[n8];
                for (int k = 0; k < n8; k++)
                    temps[k] = sc.nextInt();
                System.out.println("Record-breaking days: " + weatherStation(temps));
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}
