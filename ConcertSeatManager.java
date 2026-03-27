import java.util.Scanner;

public class ConcertSeatManager {

    // Method to find first duplicate seat request
    public static String findFirstDuplicate(String[][] bookings) {

        for (int i = 0; i < bookings.length; i++) {
            for (int j = 0; j < i; j++) {
                if (bookings[i][1].equals(bookings[j][1])) {
                    return bookings[i][0]; // customer ID
                }
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();

        String[][] bookings = new String[n][2];

        System.out.println("Enter Customer ID and Seat Number (id seat):");
        for (int i = 0; i < n; i++) {
            bookings[i][0] = sc.next(); // Customer ID
            bookings[i][1] = sc.next(); // Seat Number
        }

        String result = findFirstDuplicate(bookings);
        System.out.println("Output: " + result);
    }
}
