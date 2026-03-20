package Story_7;

import java.util.*;

class Task_2 {
    static int[][] dp;

    public static int solve(int[][] S, int i, int mask) {
        int n = S.length;

        if (i == n) return 0;

        if (dp[i][mask] != -1) return dp[i][mask];

        int max = 0;

        for (int j = 0; j < n; j++) {
            if ((mask & (1 << j)) == 0) {
                int score = S[i][j] + solve(S, i + 1, mask | (1 << j));
                max = Math.max(max, score);
            }
        }

        return dp[i][mask] = max;
    }

    public static int maxCompatibility(int[][] S) {
        int n = S.length;
        dp = new int[n][1 << n];

        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(S, 0, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        int[][] S = new int[n][n];

        System.out.println("Enter compatibility matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        int result = maxCompatibility(S);
        System.out.println("Maximum Compatibility Score: " + result);

        sc.close();
    }
}
