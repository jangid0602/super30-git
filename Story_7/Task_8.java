package Story_7;

import java.util.*;

class Task_8 {

    static long[][][] dp;
    static String num;

    static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    static long solve(int pos, int sum, int tight) {
        if (pos == num.length()) {
            return isPrime(sum) ? 1 : 0;
        }

        if (dp[pos][sum][tight] != -1) return dp[pos][sum][tight];

        int limit = (tight == 1) ? num.charAt(pos) - '0' : 9;
        long res = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;
            res += solve(pos + 1, sum + d, newTight);
        }

        return dp[pos][sum][tight] = res;
    }

    static long count(long x) {
        num = Long.toString(x);
        dp = new long[20][200][2];

        for (long[][] a : dp)
            for (long[] b : a)
                Arrays.fill(b, -1);

        return solve(0, 0, 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter L: ");
        long L = sc.nextLong();

        System.out.print("Enter R: ");
        long R = sc.nextLong();

        long result = count(R) - count(L - 1);
        System.out.println("Answer: " + result);

        sc.close();
    }
}
