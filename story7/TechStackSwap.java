package story7;

import java.util.*;

/**
 * TechStackSwap calculates the minimum cost required to transform
 * one technology stack (string A) into another stack (string B).
 *
 * Allowed operations:
 * 1. Insert a technology
 * 2. Delete a technology
 * 3. Upgrade (Replace) a technology
 *
 * Each operation has its own cost.
 *
 * This problem is a variation of the Edit Distance algorithm
 * solved using Dynamic Programming.
 */
public class TechStackSwap {

    /**
     * Computes the minimum transformation cost from string A to string B.
     *
     * @param A  Source technology stack
     * @param B  Target technology stack
     * @param Ci Cost of insertion
     * @param Cd Cost of deletion
     * @param Cu Cost of replacement (upgrade)
     * @return Minimum cost required to transform A into B
     */
    public static int minCost(String A, String B, int Ci, int Cd, int Cu) {

        int n = A.length(); // length of first stack
        int m = B.length(); // length of second stack

        // DP table where dp[i][j] represents the minimum cost
        // to convert first i characters of A into first j characters of B
        int[][] dp = new int[n + 1][m + 1];

        // Base case:
        // If B is empty, delete all characters from A
        for (int i = 0; i <= n; i++)
            dp[i][0] = i * Cd;

        // Base case:
        // If A is empty, insert all characters of B
        for (int j = 0; j <= m; j++)
            dp[0][j] = j * Ci;

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If characters are same, no operation needed
                if (A.charAt(i - 1) == B.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    // Calculate cost for all three operations

                    // Insert operation
                    int insert = dp[i][j - 1] + Ci;

                    // Delete operation
                    int delete = dp[i - 1][j] + Cd;

                    // Replace (upgrade) operation
                    int replace = dp[i - 1][j - 1] + Cu;

                    // Choose the operation with minimum cost
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        // Final answer: minimum cost to convert A into B
        return dp[n][m];
    }

    /**
     * Main method to take input from the user
     * and display the minimum transformation cost.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input source stack
        System.out.print("Enter Stack A: ");
        String A = sc.next();

        // Input target stack
        System.out.print("Enter Stack B: ");
        String B = sc.next();

        // Input operation costs
        System.out.print("Insert cost: ");
        int Ci = sc.nextInt();

        System.out.print("Delete cost: ");
        int Cd = sc.nextInt();

        System.out.print("Upgrade cost: ");
        int Cu = sc.nextInt();

        // Calculate minimum transformation cost
        int result = minCost(A, B, Ci, Cd, Cu);

        // Print result
        System.out.println("Minimum Cost: " + result);

        sc.close();
    }
}