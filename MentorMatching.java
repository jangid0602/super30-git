public class MentorMatching {

    static int solve(int[][] S, int mask, int mentor, int n, int[] dp) {
        if (mentor == n) return 0;

        if (dp[mask] != -1) return dp[mask];

        int ans = 0;

        for (int student = 0; student < n; student++) {
            if ((mask & (1 << student)) == 0) {
                ans = Math.max(ans,
                        S[mentor][student] +
                        solve(S, mask | (1 << student), mentor + 1, n, dp));
            }
        }

        return dp[mask] = ans;
    }

   
}