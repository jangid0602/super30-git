package story7;

import java.util.*;

/**
 * PlacementMarathon solves the problem of finding the longest subsequence
 * where the difference between adjacent elements is exactly K.
 */
public class PlacementMarathon {

    /**
     * Finds the length of the longest subsequence where
     * difference between adjacent elements is exactly K.
     *
     * @param arr Array of student skill levels
     * @param K   Required difference between adjacent elements
     * @return Length of the longest valid subsequence
     */
    public int longestSubsequence(int[] arr, int K) {

        HashMap<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int num : arr) {

            int prev = num - K;

            int length = dp.getOrDefault(prev, 0) + 1;

            dp.put(num, length);

            maxLen = Math.max(maxLen, length);
        }

        return maxLen;
    }

    /**
     * Main method to test the Placement Marathon problem.
     * Reads input from the user and prints the result.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        System.out.print("Enter K: ");
        int K = sc.nextInt();

        int[] A = new int[N];

        System.out.println("Enter array elements:");

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        PlacementMarathon obj = new PlacementMarathon();

        int result = obj.longestSubsequence(A, K);

        System.out.println("Longest subsequence length: " + result);

        sc.close();
    }
}