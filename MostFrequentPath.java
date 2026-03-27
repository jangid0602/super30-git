import java.util.*;
import java.util.*;

public class MostFrequentPath {

    // Function to find the most frequent path
    public static String mostFrequentPath(List<String> actions) {

        int n = actions.size();
        boolean[] vis = new boolean[n];
        List<String> paths = new ArrayList<>();

        // Build paths for each user
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;

            String user = actions.get(i).substring(0, 2); // first 2 chars = user
            String currPath = "";

            for (int j = i; j < n; j++) {
                if (vis[j]) continue;

                String currUser = actions.get(j).substring(0, 2);
                String currActions = actions.get(j).substring(2);
                String temp = actions.get(j).substring(4);

                if (user.equals(currUser)) {
                    if (!currPath.isEmpty()) {
                        currPath += currActions;   // append
                        paths.add(currPath);       // store path
                    }
                    currPath = temp;               // new path start
                    vis[j] = true;
                }
            }
        }

        // Find most frequent path
        String journey = "{zzzzzzzzzz"; // big lexicographical value
        int size = paths.size();

        boolean[] visited = new boolean[size];
        int[] counts = new int[size];
        int maxCount = 0;

        for (int i = 0; i < size; i++) {
            if (visited[i]) continue;

            int count = 0;
            for (int j = i; j < size; j++) {
                if (!visited[j] && paths.get(i).equals(paths.get(j))) {
                    visited[j] = true;
                    count++;
                }
            }

            counts[i] = count;
            maxCount = Math.max(maxCount, count);
        }

        // Find lexicographically smallest among most frequent
        for (int i = 0; i < size; i++) {
            if (counts[i] == maxCount) {
                if (paths.get(i).compareTo(journey) < 0) {
                    journey = paths.get(i);
                }
            }
        }

        return journey;
    }

    // MAIN PROGRAM
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of actions: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        List<String> actions = new ArrayList<>();
        System.out.println("Enter actions (example: ABm1n2):");

        for (int i = 0; i < n; i++) {
            actions.add(sc.nextLine());
        }

        String result = mostFrequentPath(actions);
        System.out.println("Most Frequent Path = " + result);
    }
}
