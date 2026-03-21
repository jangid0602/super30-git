import java.util.*;

public class CodeUpShow {

    public static double solve(int duration, int i, List<int[]> list, double[][] dp) {

        if (duration == 0 || i < 0) return 0;

        if (dp[duration][i] != -1) return dp[duration][i];

        int dur = list.get(i)[0];
        int profit = list.get(i)[1];

        // Exclude
        double exclude = solve(duration, i - 1, list, dp);

        // Take once
        double include = 0;
        if (dur <= duration) {
            include = profit + solve(duration - dur, i - 1, list, dp);
        }

        // Take twice (second time 50%)
        double takeTwice = 0;
        if (duration >= 2 * dur) {
            takeTwice = profit + (profit * 0.5)
                    + solve(duration - 2 * dur, i - 1, list, dp);
        }

        return dp[duration][i] =
                Math.max(exclude, Math.max(include, takeTwice));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the duration of ad in(seconds)");
        int T = sc.nextInt();
        System.out.println("Enter the duration and profit");
        List<int[]> list = new ArrayList<>();

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == -1 && b == -1) break;
            list.add(new int[]{a, b});
        }

        int n = list.size();
        double[][] dp = new double[T + 1][n];

        for (double[] row : dp) {
            Arrays.fill(row, -1);
        }

        double ans = solve(T, n - 1, list, dp);
        System.out.println(ans);
    }
}
