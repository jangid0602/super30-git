import java.util.*;

public class TechStackSwap {

    public int minimumCost(String tech1, String tech2, int i, int j,
                           int insertCost, int deleteCost, int replaceCost,
                           int[][] dp) {

        int n = tech1.length();
        int m = tech2.length();

        if (i == n && j == m) {
            return 0;
        } 
        else if (i == n) {
            return (m - j) * insertCost;
        } 
        else if (j == m) {
            return (n - i) * deleteCost;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (tech1.charAt(i) == tech2.charAt(j)) {
            return dp[i][j] = minimumCost(
                    tech1, tech2, i + 1, j + 1,
                    insertCost, deleteCost, replaceCost, dp
            );
        } 
        else {

            int insert = minimumCost(
                    tech1, tech2, i, j + 1,
                    insertCost, deleteCost, replaceCost, dp
            ) + insertCost;

            int delete = minimumCost(
                    tech1, tech2, i + 1, j,
                    insertCost, deleteCost, replaceCost, dp
            ) + deleteCost;

            int replace = minimumCost(
                    tech1, tech2, i + 1, j + 1,
                    insertCost, deleteCost, replaceCost, dp
            ) + replaceCost;

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }

    public int swapStacks() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tech two stacks:");
        String tech1 = sc.nextLine();
        String tech2 = sc.nextLine();

        System.out.println("Enter insert, delete, replace cost:");
        int insertCost = sc.nextInt();
        int deleteCost = sc.nextInt();
        int replaceCost = sc.nextInt();

        int n = tech1.length();
        int m = tech2.length();

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return minimumCost(
                tech1, tech2, 0, 0,
                insertCost, deleteCost, replaceCost, dp
        );
    }

    public static void main(String[] args) {

        TechStackSwap techStacks = new TechStackSwap();

        System.out.println(techStacks.swapStacks());
    }
}
