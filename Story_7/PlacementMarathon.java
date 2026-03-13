package Codeup.Story_7;
import java.util.*;

public class PlacementMarathon {

        public int minimumSum(int[] powers, int i, int k, int[][] dp) {

            if (i >= powers.length) {
                if (k == 0)
                    return 0;
                else
                    return (int)1e7;
            }

            if (k <= 0) {
                return (int)1e7;
            }

            if (dp[i][k] != -1) {
                return dp[i][k];
            }

            int minCost = Integer.MAX_VALUE;
            int mini = Integer.MAX_VALUE;
            int maxi = Integer.MIN_VALUE;

            for (int j = i; j < powers.length; j++) {

                mini = Math.min(mini, powers[j]);
                maxi = Math.max(maxi, powers[j]);

                int currCost = minimumSum(powers, j + 1, k - 1, dp) + (maxi - mini);

                minCost = Math.min(minCost, currCost);
            }

            return dp[i][k] = minCost;
        }

        public int findMinimumSum() {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of servers and number of clusters: ");
            int servers = sc.nextInt();
            int k = sc.nextInt();

            int[] powers = new int[servers];

            System.out.println("Enter power of each server:");

            for (int i = 0; i < servers; i++) {
                powers[i] = sc.nextInt();
            }

            int[][] dp = new int[servers + 1][k + 1];

            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            return minimumSum(powers, 0, k, dp);
        }

        public static void main(String[] args) {

            PlacementMarathon servers = new PlacementMarathon();

            System.out.println(servers.findMinimumSum());
        }
}
