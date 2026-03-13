package story7;

import java.util.*;

/**
 * StartupRevenue calculates the maximum revenue that can be earned
 * over N days with the following rules:
 * 
 * 1. If you work on day i, you must rest on day i+1.
 * 2. Every 7th day (7, 14, 21, ...) the revenue is doubled.
 * 
 * This is a variation of the House Robber Dynamic Programming problem.
 */
public class StartupRevenue {

    /**
     * Calculates the maximum possible revenue.
     *
     * @param A Array containing revenue for each day
     * @return Maximum revenue that can be earned
     */
    public int maxRevenue(int[] A) {

        int n = A.length;

        // If there are no days, revenue is 0
        if (n == 0) return 0;

        // If there is only one day
        if (n == 1) {
            int value = (1 % 7 == 0) ? 2 * A[0] : A[0];
            return value;
        }

        // dp[i] = maximum revenue achievable up to day i
        int[] dp = new int[n + 1];

        // Iterate through all days
        for (int i = 1; i <= n; i++) {

            // Revenue of current day
            int value = A[i - 1];

            // If it is a multiple of 7, revenue doubles
            if (i % 7 == 0) {
                value = 2 * value;
            }

            // Base case: first day
            if (i == 1) {
                dp[i] = value;
            } else {

                // Two choices:
                // 1. Rest today -> dp[i-1]
                // 2. Work today -> dp[i-2] + today's revenue
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + value);
            }
        }

        // Result: maximum revenue after N days
        return dp[n];
    }

    /**
     * Main method to read input from the user
     * and display the maximum revenue.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of days
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] A = new int[n];

        // Read revenue for each day
        System.out.println("Enter revenue for each day:");

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        // Create object and compute result
        StartupRevenue sol = new StartupRevenue();
        int result = sol.maxRevenue(A);

        // Print maximum revenue
        System.out.println("Maximum Revenue: " + result);

        sc.close();
    }
}