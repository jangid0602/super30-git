package story7;

import java.util.Scanner;

/**
 * MantorshipMatching solves the mentor-student assignment problem
 * using Bitmask Dynamic Programming.
 * 
 * Each mentor must be assigned exactly one student, and each student
 * can be assigned to only one mentor. The goal is to maximize the
 * total compatibility score.
 */
public class MantorshipMatching {

    /**
     * Calculates the maximum compatibility score.
     *
     * @param S Compatibility score matrix where S[i][j] represents
     *          compatibility between mentor i and student j.
     * @param N Number of mentors/students
     * @return Maximum total compatibility score
     */
    public static int maxCompatibility(int[][] S, int N) {

        // Total number of bitmask states (2^N)
        int size = 1 << N;

        // dp[mask] stores maximum compatibility score for this mask
        int[] dp = new int[size];

        // Iterate through all assignment states
        for (int mask = 0; mask < size; mask++) {

            // Count how many students are already assigned
            int mentor = Integer.bitCount(mask);

            // If all mentors are already assigned, skip
            if (mentor >= N)
                continue;

            // Try assigning current mentor to an unassigned student
            for (int student = 0; student < N; student++) {

                // Check if this student is not yet assigned
                if ((mask & (1 << student)) == 0) {

                    // Create new mask with this student assigned
                    int newMask = mask | (1 << student);

                    // Update DP state with maximum compatibility
                    dp[newMask] = Math.max(
                            dp[newMask],
                            dp[mask] + S[mentor][student]);
                }
            }
        }

        // Final state where all students are assigned
        return dp[size - 1];
    }

    /**
     * Main method to read input and display the maximum compatibility score.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of mentors/students
        System.out.print("Enter N: ");
        int N = sc.nextInt();

        // Compatibility score matrix
        int[][] S = new int[N][N];

        System.out.println("Enter compatibility matrix:");

        // Input the compatibility scores
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        // Compute maximum compatibility score
        int result = maxCompatibility(S, N);

        // Display result
        System.out.println("Maximum Compatibility Score: " + result);

        sc.close();
    }
}