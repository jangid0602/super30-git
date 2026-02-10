package week4story;

import java.util.Scanner;

public class StaircaseArchitect {

    /**
     * Calculates the total number of ways to climb
     * a staircase of n steps.
     *
     * The person can climb either 1 step or 2 steps at a time.
     *
     * @param n The total number of steps in the staircase
     * @return The total number of distinct ways to reach the top
     */
    public int calculateTotalWays(int n) {

        // Base cases: when steps are 1, 2, or 3
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }

        // Recursive case: ways from (n-1) and (n-2) steps
        int wayNm1 = calculateTotalWays(n - 1);
        int wayNm2 = calculateTotalWays(n - 2);

        // Total ways is the sum of both possibilities
        int totalWays = wayNm1 + wayNm2;

        return totalWays;
    }

    public static void main(String[] args) {
        StaircaseArchitect obj = new StaircaseArchitect();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N : ");
        int n = sc.nextInt();

        int output = obj.calculateTotalWays(n);
        System.out.println("Total Ways : " + output);

        sc.close();
    }
}
