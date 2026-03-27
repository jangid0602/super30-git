import java.util.Scanner;

public class SecurityLogAnalyzer {

    // Method to calculate range sum (brute force)
    public static int rangeSum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] logins = new int[n];
        System.out.println("Enter login counts:");
        for (int i = 0; i < n; i++) {
            logins[i] = sc.nextInt();
        }

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        int result = rangeSum(logins, start, end);
        System.out.println("Total logins = " + result);
    }
}
