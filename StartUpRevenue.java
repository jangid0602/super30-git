
public class StartUpRevenue {
    public static int maxRevenue(int[] A) {
        int n = A.length;
        int[] dp = new int[n];

        dp[0] = A[0];

        for (int i = 1; i < n; i++) {
            int value = A[i];
            if ((i + 1) % 7 == 0) { // every 7th day
                value = 2 * value;
            }

            int take = value;
            if (i > 1) take += dp[i - 2];

            int skip = dp[i - 1];

            dp[i] = Math.max(take, skip);
        }

        return dp[n - 1];
    }


}