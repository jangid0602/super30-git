package Story_7;

import java.util.*;

class Task_6 {
    public static int maxProfit(int T, int[][] ads) {
        List<int[]> items = new ArrayList<>();

        for (int[] ad : ads) {
            int d = ad[0];
            int p = ad[1];

            items.add(new int[]{d, p});
            items.add(new int[]{d, p / 2});
        }

        int[] dp = new int[T + 1];

        for (int[] item : items) {
            int d = item[0];
            int p = item[1];

            for (int t = T; t >= d; t--) {
                dp[t] = Math.max(dp[t], dp[t - d] + p);
            }
        }

        return dp[T];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter T: ");
        int T = sc.nextInt();

        System.out.print("Enter number of ads: ");
        int n = sc.nextInt();

        int[][] ads = new int[n][2];

        System.out.println("Enter duration and profit:");
        for (int i = 0; i < n; i++) {
            ads[i][0] = sc.nextInt();
            ads[i][1] = sc.nextInt();
        }

        int result = maxProfit(T, ads);
        System.out.println("Maximum Profit: " + result);

        sc.close();
    }
}
