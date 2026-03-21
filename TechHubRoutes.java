
import java.util.*;

public class TechHubRoutes {

    static final int MOD = 1000000007;
    static boolean[] isPrime = new boolean[200];

    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < 200; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 200; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    static long count(String num) {
        int n = num.length();

        long[][][] dp = new long[n + 1][200][2];
        dp[0][0][1] = 1; // start with tight=1

        for (int pos = 0; pos < n; pos++) {
            for (int sum = 0; sum < 200; sum++) {
                for (int tight = 0; tight <= 1; tight++) {

                    if (dp[pos][sum][tight] == 0) continue;

                    int limit = (tight == 1) ? num.charAt(pos) - '0' : 9;

                    for (int d = 0; d <= limit; d++) {
                        int newSum = sum + d;
                        int newTight = (tight == 1 && d == limit) ? 1 : 0;

                        dp[pos + 1][newSum][newTight] =
                                (dp[pos + 1][newSum][newTight] + dp[pos][sum][tight]) % MOD;
                    }
                }
            }
        }

        long ans = 0;

        for (int sum = 0; sum < 200; sum++) {
            if (isPrime[sum]) {
                ans = (ans + dp[n][sum][0] + dp[n][sum][1]) % MOD;
            }
        }

        return ans;
    }

    static String minusOne(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = sb.length() - 1;

        while (i >= 0 && sb.charAt(i) == '0') {
            sb.setCharAt(i, '9');
            i--;
        }

        if (i >= 0)
            sb.setCharAt(i, (char)(sb.charAt(i) - 1));

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sieve();

        String L = sc.next();
        String R = sc.next();

        long right = count(R);
        long left = count(minusOne(L));

        long ans = (right - left + MOD) % MOD;

        System.out.println(ans);
    }
}