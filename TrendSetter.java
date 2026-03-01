import java.util.Scanner;

public class TrendSetter {
    // to count how many groups have a trendsetter
    static int countTrendsetters(int[] posts, int k) {
        int trendCount = 0;
        int n = posts.length;
        for (int start = 0; start <= n - k; start++) {
            // Count frequencies inside the group
            int[] values = new int[k];
            int[] freq = new int[k];
            int u = 0;   // number of unique values
            for (int i = start; i < start + k; i++) {
                int val = posts[i];
                boolean found = false;

                for (int j = 0; j < u; j++) {
                    if (values[j] == val) {
                        freq[j]++;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    values[u] = val;
                    freq[u] = 1;
                    u++;
                }
            }

            // Find max frequency
            int max = 0;
            for (int i = 0; i < u; i++) {
                if (freq[i] > max) max = freq[i];
            }

            // Count how many have the max frequency
            int maxCount = 0;
            for (int i = 0; i < u; i++) {
                if (freq[i] == max) maxCount++;
            }

            if (maxCount == 1) trendCount++;
        }

        return trendCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of posts: ");
        int n = sc.nextInt();

        int[] posts = new int[n];
        System.out.println("Enter post IDs:");
        for (int i = 0; i < n; i++) posts[i] = sc.nextInt();

        System.out.print("Group size: ");
        int k = sc.nextInt();

        System.out.println("Number of trendsetter groups: " + countTrendsetters(posts, k));

    }
}
