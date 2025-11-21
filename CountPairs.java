import java.util.*;

public class CountPairs {

    // Function to count pairs whose sum is k
    public static int countPairs(List<Integer> nums, int k) {
        int n = nums.size();
        boolean[] vis = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;

            for (int j = i + 1; j < n; j++) {
                if (vis[j]) continue;

                if (nums.get(i) + nums.get(j) == k) {
                    vis[i] = true;
                    vis[j] = true;
                    count++;
                    System.out.println("Pair found at indices: " + i + " " + j);
                    break;
                }
            }
        }

        return count;
    }

    // MAIN PROGRAM
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        List<Integer> nums = new ArrayList<>();

        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            nums.add(sc.nextInt());
        }

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        int result = countPairs(nums, k);
        System.out.println("Total pairs = " + result);
    }
}
