import java.util.*;

public class Assignment2 {

    // 1. Cosmic Courier Challenge
    static int cosmicCourier(int[] arr) {
        int max = 0, secondMax = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    // 2. Digital Library System
    static void digitalLibrary(String[] books, String search, int type) {
        for (int i = 0; i < books.length; i++) {
            if (type == 1 && books[i].equals(search)) {
                System.out.println(books[i]);
            } else if (type == 2 && books[i].contains(search)) {
                System.out.println(books[i]);
            }
        }
    }

    // 3. Factory Floor Robot
    static void factoryRobot(int[] weights) {
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

    // 4. Spy’s Cipher
    static char spyCipher(String original, String scrambled) {
        int[] count = new int[256];

        for (int i = 0; i < scrambled.length(); i++)
            count[scrambled.charAt(i)]++;

        for (int i = 0; i < original.length(); i++)
            count[original.charAt(i)]--;

        for (int i = 0; i < 256; i++)
            if (count[i] == 1)
                return (char) i;

        return ' ';
    }

    // 5. Corporate Hierarchy
    static double corporateHierarchy(double salary, int role) {
        if (role == 1)
            return salary * 0.10;
        else if (role == 2)
            return salary * 0.25 + 5000;
        else
            return salary * 0.50 + 10000;
    }

    // 6. Security Log Analyzer
    static int securityLog(int[] arr, int i, int j) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for (int k = 1; k < arr.length; k++)
            prefix[k] = prefix[k - 1] + arr[k];

        return (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
    }

    // 7. Concert Seat Manager
    static String concertSeat(String[] cust, int[] seats) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < i; j++) {
                if (seats[i] == seats[j])
                    return cust[i];
            }
        }
        return "-1";
    }

    // 8. Weather Station
    static int weatherStation(int[] temps) {
        int max = Integer.MIN_VALUE, count = 0;

        for (int i = 0; i < temps.length; i++) {
            if (temps[i] > max) {
                max = temps[i];
                count++;
            }
        }
        return count;
    }

    // MAIN METHOD (ALL INPUT HERE)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Question (1-8): ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                int n1 = sc.nextInt();
                int[] routes = new int[n1];
                for (int i = 0; i < n1; i++)
                    routes[i] = sc.nextInt();
                System.out.println(cosmicCourier(routes));
                break;

            case 2:
                int n2 = sc.nextInt();
                sc.nextLine();
                String[] books = new String[n2];
                for (int i = 0; i < n2; i++)
                    books[i] = sc.nextLine();
                String search = sc.nextLine();
                int type = sc.nextInt();
                digitalLibrary(books, search, type);
                break;

            case 3:
                int n3 = sc.nextInt();
                int[] weights = new int[n3];
                for (int i = 0; i < n3; i++)
                    weights[i] = sc.nextInt();
                factoryRobot(weights);
                break;

            case 4:
                sc.nextLine();
                String original = sc.nextLine();
                String scrambled = sc.nextLine();
                System.out.println(spyCipher(original, scrambled));
                break;

            case 5:
                double salary = sc.nextDouble();
                int role = sc.nextInt();
                System.out.println(corporateHierarchy(salary, role));
                break;

            case 6:
                int n6 = sc.nextInt();
                int[] logins = new int[n6];
                for (int i = 0; i < n6; i++)
                    logins[i] = sc.nextInt();
                int i = sc.nextInt();
                int j = sc.nextInt();
                System.out.println(securityLog(logins, i, j));
                break;

            case 7:
                int n7 = sc.nextInt();
                String[] cust = new String[n7];
                int[] seats = new int[n7];
                for (int k = 0; k < n7; k++) {
                    cust[k] = sc.next();
                    seats[k] = sc.nextInt();
                }
                System.out.println(concertSeat(cust, seats));
                break;

            case 8:
                int n8 = sc.nextInt();
                int[] temps = new int[n8];
                for (int k = 0; k < n8; k++)
                    temps[k] = sc.nextInt();
                System.out.println(weatherStation(temps));
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}
