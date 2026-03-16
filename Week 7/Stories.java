/**
 * 
 * This is Stories class and it contains all the function definitions called in the Main class.
 * 
 * 1. startupwagesMaxima
 * 2. mentorshipMatching
 * 3. techStackSwap
 * 4. placementMarathon
 * 5. optimalServerLatency
 * 
 * Owner : Ayush Joshi
 * Last Updated : 13/3/2026
 */
import java.util.Arrays;
import java.util.HashMap;

public class Stories {
    // Problem 1: The Startup wages Maxima (Linear DP)
    public int startupwagesMaxima(int[] wages) {
        int n = wages.length;
        if (n == 0) return 0;
        if (n == 1) return wages[0];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int currentDayWages = ((i + 1) % 7 == 0) ? 2 * wages[i] : wages[i];

            if (i == 0) {
                dp[i] = currentDayWages;
            } else if (i == 1) {
                dp[i] = Math.max(dp[0], currentDayWages);
            } else {
                dp[i] = Math.max(dp[i - 1], currentDayWages + dp[i - 2]);
            }
        }
        return dp[n - 1];
    }

    // Problem 2: Codeup Mentorship Matching (Bitmask DP)
    public int mentorshipMatching(int n, int[][] scores) {
        int numMasks = 1 << n; 
        int[] dp = new int[numMasks];
        for (int mask = 0; mask < numMasks - 1; mask++) {
            int mentorIdx = Integer.bitCount(mask);
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) == 0) {
                    int nextMask = mask | (1 << j);
                    dp[nextMask] = Math.max(dp[nextMask], dp[mask] + scores[mentorIdx][j]);
                }
            }
        }
        return dp[numMasks - 1];
    }

    // Problem 3: The Minimal Tech-Stack Swap (Edit Distance Variation)
    public int techStackSwap(String s1, String s2, int ci, int cd, int cu) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++){
            dp[i][0] = i * cd;
        }
        for (int j = 0; j <= n; j++){
            dp[0][j] = j * ci; 
        } 

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int delete = dp[i - 1][j] + cd;
                    int insert = dp[i][j - 1] + ci;
                    int upgrade = dp[i - 1][j - 1] + cu;
                    dp[i][j] = Math.min(delete, Math.min(insert, upgrade));
                }
            }
        }
        return dp[m][n];
    }

    // Problem 4: Placement Marathon (DP on Subsequences)
    public int placementMarathon(int[] a, int k) {
        if (a == null || a.length == 0) return 0;
        HashMap<Integer, Integer> dp = new HashMap<>();
        int maxLength = 0;
        for (int val : a) {
            int prev1 = val - k;
            int prev2 = val + k;
            int len1 = dp.getOrDefault(prev1, 0);
            int len2 = dp.getOrDefault(prev2, 0);
            int currentLen = 1 + Math.max(len1, len2);
            dp.put(val, Math.max(dp.getOrDefault(val, 0), currentLen));
            maxLength = Math.max(maxLength, currentLen);
        }
        return maxLength;
    }

    // Problem 5: The Optimal Server Latency (Partition DP)
    public int optimalServerLatency(int[] a, int k) {
        int n = a.length;
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], 1000000); 
        }
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) { 
            for (int j = 1; j <= n; j++) { 
                int maxVal = Integer.MIN_VALUE;
                int minVal = Integer.MAX_VALUE;
                for (int p = j; p >= i; p--) {
                    maxVal = Math.max(maxVal, a[p - 1]);
                    minVal = Math.min(minVal, a[p - 1]);
                    int currentUnbalance = maxVal - minVal;
                    
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][p - 1] + currentUnbalance);
                }
            }
        }
        return dp[k][n];
    }
}
