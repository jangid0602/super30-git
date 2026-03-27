import java.util.*;

public class TrendSetter {

    // Function to count trendsetters
    public static int trendSetter(List<Integer> posts, int k) {
        int trendsetters = 0;

        for (int i = 0; i <= posts.size() - k; i++) {

            // Frequency map for the current window
            Map<Integer, Integer> freq = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                freq.put(posts.get(j), freq.getOrDefault(posts.get(j), 0) + 1);
            }

            // Find the maximum frequency
            int maxFreq = Collections.max(freq.values());

            // Count how many values appear maxFreq times
            int countMax = 0;
            for (int val : freq.values()) {
                if (val == maxFreq) countMax++;
            }

            // Unique trendsetter condition
            if (countMax == 1) trendsetters++;
        }

        return trendsetters;
    }

    // MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // INPUT
        System.out.print("Enter number of posts: ");
        int n = sc.nextInt();

        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        List<Integer> posts = new ArrayList<>();
        System.out.println("Enter posts:");

        for (int i = 0; i < n; i++) {
            posts.add(sc.nextInt());
        }

        int result = trendSetter(posts, k);

        // OUTPUT
        System.out.println("Number of Trend Setters = " + result);
    }
}
