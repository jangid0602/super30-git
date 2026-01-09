// package story_2.5;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

/* =========================================================
   1. The Weather Station Data Aggregator
   ========================================================= */
class WeatherStation {

    /**
     * Counts the number of days when the temperature was strictly higher
     * than all previous days.
     *
     * The first day is always considered a record.
     *
     * @param temp An array of daily temperatures
     * @return The total number of record days
     */
    public int temperatureRecordCounter(int temp[]) {
        if (temp == null || temp.length == 0) {
            return 0; // no days, no records
        }

        int highest = temp[0];
        int count = 1;

        for (int i = 1; i < temp.length; i++) {
            if (temp[i] > highest) {
                highest = temp[i];
                count++;
            }
        }
        return count;
    }
}

/*
 * =========================================================
 * 2. The Concert Seat Manager
 * =========================================================
 */
class ConcertSeatManager {

    /**
     * Finds the first customer who tries to book an already booked seat.
     *
     * @param requests 2D array containing [CustomerID, SeatNumber]
     * @return CustomerID of the first duplicate seat request, or "-1"
     */
    public String findFirstDuplicateSeat(String[][] requests) {

        HashMap<String, String> seatMap = new HashMap<>();

        for (int i = 0; i < requests.length; i++) {
            String customerId = requests[i][0];
            String seatNumber = requests[i][1];

            if (seatMap.containsKey(seatNumber)) {
                return customerId;
            }
            seatMap.put(seatNumber, customerId);
        }
        return "-1";
    }
}

/*
 * =========================================================
 * 3. The Cosmic Courier Challenge
 * =========================================================
 */
class CosmicCourier {

    /**
     * Computes the minimum possible deadline after removing
     * at most one route from the given array.
     *
     * @param routes an integer array representing travel times of routes
     * @return the minimum possible deadline
     */
    public int minimumDeadline(int[] routes) {

        // Edge case: If there is only one route, it cannot be removed
        if (routes.length == 1) {
            return routes[0];
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int time : routes) {
            if (time > max) {
                secondMax = max;
                max = time;
            } else if (time > secondMax) {
                secondMax = time;
            }
        }

        // If removing the maximum reduces the deadline,
        // return second maximum; otherwise return original maximum
        return (secondMax < max) ? secondMax : max;
    }
}

/*
 * =========================================================
 * 4. The Security Log Analyzer
 * =========================================================
 */
class SecurityLogAnalyzer {

    static int[] prefix;

    public static void prefixSumArr(int[] logins) {
        int n = logins.length;
        prefix = new int[n];

        prefix[0] = logins[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + logins[i];
        }
    }

    /**
     * Returns total logins between day i and day j (inclusive)
     * in O(1) time
     */
    public static int query(int i, int j) {
        if (i == 0) {
            return prefix[j];
        }
        return prefix[j] - prefix[i - 1];
    }
}

/*
 * =========================================================
 * 5. The Spy's Cipher
 * =========================================================
 */
class SpysCipher {

    public int[] freq(String str) {
        int freq[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            freq[index]++;
        }
        return freq;
    }

    public char compareStr(String str1, String str2) {

        int[] f1 = freq(str1);
        int[] f2 = freq(str2);

        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i]) {
                return (char) (i + 'a');
            }
        }
        return '-'; // no mismatch
    }
}

/*
 * =========================================================
 * 6. The Digital Library System
 * =========================================================
 */
class Book {

    private String title; // Encapsulation

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "Book(\"" + title + "\")";
    }
}

class Library {

    private List<Book> books = new ArrayList<>();

    // Add book
    public void addBook(String title) {
        books.add(new Book(title));
    }

    // Remove book
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    // Exact match search
    public List<Book> search(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Partial match search (Polymorphism)
    public List<Book> search(String title, boolean partial) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        return result;
    }
}

/*
 * =========================================================
 * MAIN DRIVER CLASS (SWITCH BASED)
 * =========================================================
 */
public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Problem to Run:");
        System.out.println("1. Weather Station");
        System.out.println("2. Concert Seat Manager");
        System.out.println("3. Cosmic Courier");
        System.out.println("4. Security Log Analyzer");
        System.out.println("5. Spy's Cipher");
        System.out.println("6. Digital Library System");

        System.out.print("Enter your choice (1-6): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {

            /* ===================== 1 ===================== */
            case 1:
                WeatherStation ws = new WeatherStation();

                System.out.print("Enter number of days: ");
                int n = sc.nextInt();
                int[] temps = new int[n];

                System.out.println("Enter temperatures:");
                for (int i = 0; i < n; i++) {
                    temps[i] = sc.nextInt();
                }

                System.out.println("Record Days: "
                        + ws.temperatureRecordCounter(temps));
                break;

            /* ===================== 2 ===================== */
            case 2:
                ConcertSeatManager csm = new ConcertSeatManager();

                System.out.print("Enter number of seat requests: ");
                int r = sc.nextInt();
                sc.nextLine();

                String[][] seats = new String[r][2];

                for (int i = 0; i < r; i++) {
                    System.out.print("Customer ID: ");
                    seats[i][0] = sc.nextLine();

                    System.out.print("Seat Number: ");
                    seats[i][1] = sc.nextLine();
                }

                System.out.println("First Duplicate Seat Booked By: "
                        + csm.findFirstDuplicateSeat(seats));
                break;

            /* ===================== 3 ===================== */
            case 3:
                CosmicCourier cc = new CosmicCourier();

                System.out.print("Enter number of routes: ");
                int m = sc.nextInt();
                int[] routes = new int[m];

                System.out.println("Enter route travel times:");
                for (int i = 0; i < m; i++) {
                    routes[i] = sc.nextInt();
                }

                System.out.println("Minimum Deadline: "
                        + cc.minimumDeadline(routes));
                break;

            /* ===================== 4 ===================== */
            case 4:
                System.out.print("Enter number of days: ");
                int d = sc.nextInt();
                int[] logins = new int[d];

                System.out.println("Enter login data:");
                for (int i = 0; i < d; i++) {
                    logins[i] = sc.nextInt();
                }

                SecurityLogAnalyzer.prefixSumArr(logins);

                System.out.print("Enter start day (i): ");
                int i = sc.nextInt();
                System.out.print("Enter end day (j): ");
                int j = sc.nextInt();

                System.out.println("Total Logins: "
                        + SecurityLogAnalyzer.query(i, j));
                break;

            /* ===================== 5 ===================== */
            case 5:
                SpysCipher spy = new SpysCipher();

                System.out.print("Enter original string: ");
                String s1 = sc.next();

                System.out.print("Enter scrambled string: ");
                String s2 = sc.next();

                char result = spy.compareStr(s1, s2);

                if (result != '-') {
                    System.out.println("Extra Character: " + result);
                } else {
                    System.out.println("Both strings are safe");
                }
                break;

            /* ===================== 6 ===================== */
            case 6:
                Library lib = new Library();
                lib.addBook("War");
                lib.addBook("Data");
                lib.addBook("Database");
                System.out.println(lib.search("Data", true));
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}