import java.util.*;

public class LongestBalanced {

    // Function to find longest balanced subarray
    public static int longestBalanced(List<Integer> nums) {
        int n = nums.size();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int ones = 0, twos = 0;

            for (int j = i; j < n; j++) {
                if (nums.get(j) == 1) ones++;
                else if (nums.get(j) == 2) twos++;

                if (ones == twos) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // MAIN program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        List<Integer> nums = new ArrayList<>();

        System.out.println("Enter numbers (only 1 and 2):");
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        int result = longestBalanced(nums);

        System.out.println("Longest Balanced Subarray Length = " + result);
    }
}
