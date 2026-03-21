
import java.util.*;

public class OfficeSecurity {

    // linear DP (House Robber)
    public static int rob(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int take = nums[i] + prev2;
            int skip = prev1;

            int curr = Math.max(take, skip);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static int maxValue(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int case1 = rob(nums, 0, n - 2); // exclude last
        int case2 = rob(nums, 1, n - 1); // exclude first

        return Math.max(case1, case2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input size
        System.out.print("Enter number of cabins: ");
        int n = sc.nextInt();

        int[] V = new int[n];

        // dynamic input
        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            V[i] = sc.nextInt();
        }

        int result = maxValue(V);
        System.out.println("Maximum value: " + result);
    }
}
