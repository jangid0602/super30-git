import java.util.Scanner;

class LongestBalanced {
    void findLongest(int nums[], int n) {
        int maxLen = 0;
        // Try every possible subarray from index i to j
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //Find two distinct non-zero numbers in this subarray
                int a = 0, b = 0;
                for (int k = i; k <= j; k++) {
                    // ignore zeros for picking numbers
                    if (nums[k] != 0) {
                        if (a == 0) a = nums[k];
                        else if (nums[k] != a && b == 0) b = nums[k];
                    }
                }

                // if we don't have 2 numbers, skip
                if (a == 0 || b == 0) continue;
                int countA = 0;
                int countB = 0;

                for (int k = i; k <= j; k++) {
                    if (nums[k] == a) countA++;
                    if (nums[k] == b) countB++;
                }
                // check balance
                if (countA == countB) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }
        System.out.println("The length of the longest balanced subarray is: " + maxLen);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array values:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }        
        LongestBalanced b = new LongestBalanced();
        b.findLongest(nums, n);
    }
}
