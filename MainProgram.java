import java.util.*;

public class MainProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //  1 Startup Revenue
        System.out.println("Enter number of days:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter revenues:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        StartUpRevenue obj1 = new StartUpRevenue();
        System.out.println("Max Revenue: " + obj1.maxRevenue(arr));

        // -------- 2 Mentor Matching --------
        System.out.println("\nEnter number of mentors/students:");
        int m = sc.nextInt();

        int[][] S = new int[m][m];

        System.out.println("Enter compatibility matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        int[] dp = new int[1 << m];
        Arrays.fill(dp, -1);

        MentorMatching obj2 = new MentorMatching();
        System.out.println("Maximum Compatibility: "
                + obj2.solve(S, 0, 0, m, dp));

        //  3 Edit Distance
        System.out.println("\nEnter first string:");
        String s1 = sc.next();

        System.out.println("Enter second string:");
        String s2 = sc.next();

        System.out.println("Enter insert cost:");
        int ci = sc.nextInt();

        System.out.println("Enter delete cost:");
        int cd = sc.nextInt();

        System.out.println("Enter replace cost:");
        int cu = sc.nextInt();

        EditDistanceCost obj3 = new EditDistanceCost();
        System.out.println("Minimum Cost: "
                + obj3.minCost(s1, s2, ci, cd, cu));

        //  4 Placement Marathon
        System.out.println("\nEnter array size:");
        int size = sc.nextInt();

        int[] A = new int[size];

        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println("Enter difference K:");
        int k = sc.nextInt();

        PlacementMarathon obj4 = new PlacementMarathon();
        System.out.println("Longest Subsequence: "
                + obj4.longestSubseq(A, k));

        //5 Min Insertions Palindrome
        System.out.println("\nEnter string for palindrome:");
        String str = sc.next();

        MinInsertPalindrome obj5 = new MinInsertPalindrome();
        System.out.println("Minimum Insertions: "
                + obj5.minInsertions(str));

    }
}