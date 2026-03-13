package story7;

import java.util.*;

/**
 * OptimalServerLatency solves the problem of dividing servers
 * into K contiguous clusters such that the sum of cluster
 * unbalances (max - min) is minimized.
 */
public class OptimalServerLatency {

    /**
     * Calculates the minimum total unbalance.
     *
     * @param A Array representing server processing powers
     * @param N Number of servers
     * @param K Number of clusters
     * @return Minimum possible sum of cluster unbalances
     */
    public int minimizeUnbalance(int[] A, int N, int K) {

        int[][] dp = new int[K + 1][N + 1];

        for (int i = 0; i <= K; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);

        dp[0][0] = 0;

        // Number of clusters
        for (int k = 1; k <= K; k++) {

            // Servers considered
            for (int i = 1; i <= N; i++) {

                int max = A[i - 1];
                int min = A[i - 1];

                // Try all possible partition points
                for (int j = i - 1; j >= 0; j--) {

                    max = Math.max(max, A[j]);
                    min = Math.min(min, A[j]);

                    int cost = max - min;

                    dp[k][i] = Math.min(
                        dp[k][i],
                        dp[k - 1][j] + cost
                    );
                }
            }
        }

        return dp[K][N];
    }

    /**
     * Main method to read input and display result.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        System.out.print("Enter K: ");
        int K = sc.nextInt();

        int[] A = new int[N];

        System.out.println("Enter server powers:");

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        OptimalServerLatency obj = new OptimalServerLatency();

        int result = obj.minimizeUnbalance(A, N, K);

        System.out.println("Minimum total unbalance: " + result);

        sc.close();
    }
}
