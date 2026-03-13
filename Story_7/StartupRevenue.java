package Codeup.Story_7;
import java.util.*;

public class StartupRevenue {

        public int maxRevenue(int[] revenue, int index, int days, int[] dp) {

            if (index >= days) return 0;

            if (dp[index] != -1) return dp[index];

            int skip = maxRevenue(revenue, index + 1, days, dp);

            int currRevenue = revenue[index];

            if ((index + 1) % 7 == 0) {
                currRevenue = currRevenue * 2;
            }

            int take = maxRevenue(revenue, index + 2, days, dp) + currRevenue;

            return dp[index] = Math.max(skip, take);
        }

        public int findMaxRevenue() {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of days: ");
            int days = sc.nextInt();

            int[] revenue = new int[days];

            System.out.println("Enter revenue for each day:");

            for (int i = 0; i < days; i++) {
                revenue[i] = sc.nextInt();
            }

            int[] dp = new int[days];
            Arrays.fill(dp, -1);

            return maxRevenue(revenue, 0, days, dp);
        }

        public static void main(String[] args) {

            StartupRevenue startup = new StartupRevenue();

            System.out.println(startup.findMaxRevenue());
        }
}

