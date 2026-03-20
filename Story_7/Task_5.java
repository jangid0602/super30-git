package Story_7;

import java.util.*;

class Task_5 {
    public static int minCost(int[] arr, int K) {
        int n = arr.length;

        int[][] dp = new int[n + 1][K + 1];

        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= K; k++) {

                int max = arr[i - 1];
                int min = arr[i - 1];

                for (int j = i; j >= 1; j--) {
                    max = Math.max(max, arr[j - 1]);
                    min = Math.min(min, arr[j - 1]);

                    if (dp[j - 1][k - 1] != Integer.MAX_VALUE) {
                        dp[i][k] = Math.min(dp[i][k],
                                dp[j - 1][k - 1] + (max - min));
                    }
                }
            }
        }

        return dp[n][K];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = minCost(arr, k);
        System.out.println("Minimum Cost: " + result);

        sc.close();
    }
}
