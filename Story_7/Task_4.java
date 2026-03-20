package Story_7;

import java.util.*;

class Task_4 {
    public static int longestSubsequence(int[] arr, int k) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int x : arr) {
            int prev = x - k;

            int currLen = dp.getOrDefault(prev, 0) + 1;

            dp.put(x, currLen);

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input N and K
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = longestSubsequence(arr, k);
        System.out.println("Longest Subsequence Length: " + result);

        sc.close();
    }
}