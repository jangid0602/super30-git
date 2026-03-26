
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class RevenueMaxima {
    // Memoized Recursive Function
    public static int solve(int[] arr, int index, int n, int[] dp) {
        if (index >= n) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int skip = solve(arr, index + 1, n, dp);
        int mul = 1;
        if ((index + 1) % 7 == 0) {
            mul = 2;
        }
        int take = (arr[index] * mul) + solve(arr, index + 2, n, dp);
        return dp[index] = Math.max(skip, take);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the number of days (N): ");
            int n = sc.nextInt();
            if (n < 0) {
                System.out.println("Error: Number of days cannot be negative.");
                return;
            }
            if (n == 0) {
                System.out.println("Maximum Revenue: 0");
                return;
            }
            int[] A = new int[n];
            System.out.println("Enter " + n + " revenue values:");
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            int[] dp = new int[n];
            for(int i=1;i<n;i++){
                dp[i]=-1;
            }
            int result = solve(A, 0, n, dp);
            System.out.println("Maximum Revenue possible: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input! Please enter integers only.");
        } catch (NegativeArraySizeException e) {
            System.out.println("Error: Cannot create an array with negative size.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}