import java.util.*;

public class PlacementMarathon {

    public int longestSequence(int[] skills, int n, int k, int prevIdx, int i, int[][] dp) {

        if (i >= n) {
            return 0;
        }

        if (dp[prevIdx + 1][i] != -1) {
            return dp[prevIdx + 1][i];
        }

        int take = 0;

        if (prevIdx == -1 || Math.abs(skills[i] - skills[prevIdx]) == k) {
            take = longestSequence(skills, n, k, i, i + 1, dp) + 1;
        }

        int skip = longestSequence(skills, n, k, prevIdx, i + 1, dp);

        return dp[prevIdx + 1][i] = Math.max(take, skip);
    }

    public int placementMarathon() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number students and skill difference value(k): ");
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] skills = new int[n];

        System.out.println("Enter skill level of students:");

        for (int i = 0; i < n; i++) {
            skills[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return longestSequence(skills, n, k, -1, 0, dp);
    }

    public static void main(String[] args) {

        PlacementMarathon obj = new PlacementMarathon();

        System.out.println(obj.placementMarathon());
    }
}
