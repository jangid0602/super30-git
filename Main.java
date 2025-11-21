package Trendsetter.java;

import java.util.*;

public class Main {

    // Function to find number of trendsetter windows
    public static int trendSetter(List<Integer> posts, int k) {
        int trendsetters = 0;

        // Slide over each window of size k
        for (int i = 0; i <= posts.size() - k; i++) {
            List<Integer> counts = new ArrayList<>();

            // For each element in the window count its frequency
            for (int j = i; j < i + k; j++) {
                int count = 0;
                for (int idx = j; idx < i + k; idx++) {
                    if (posts.get(idx).equals(posts.get(j)))
                        count++;
                }
                counts.add(count);
            }

            // Find max frequency
            int maxi = -1;
            for (int num : counts)
                maxi = Math.max(maxi, num);

            // Count how many elements have this max frequency
            int cnt = 0;
            for (int num : counts)
                if (num == maxi) cnt++;

            // If exactly one element has the highest frequency → trendsetter
            if (cnt == 1) trendsetters++;
        }
        return trendsetters;
    }

    // Function to find longest subarray where 1s and 2s are equal
    public static int longestBalanced(List<Integer> nums) {
        int maxLen = 0;

        // Try each starting index
        for (int i = 0; i < nums.size(); i++) {
            int ones = 0, twos = 0;

            // Expand window from i → j
            for (int j = i; j < nums.size(); j++) {

                // Count 1s and 2s
                if (nums.get(j) == 1) ones++;
                else if (nums.get(j) == 2) twos++;

                // Balanced when both are equal
                if (ones == twos)
                    maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    // Count pairs with sum equal to k (each element used once)
    public static int countPairs(List<Integer> nums, int k) {
        boolean[] vis = new boolean[nums.size()];
        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (vis[i]) continue;

            for (int j = i + 1; j < nums.size(); j++) {
                if (vis[j]) continue;

                // Found pair
                if (nums.get(i) + nums.get(j) == k) {
                    vis[i] = true;
                    vis[j] = true;
                    count++;
                    System.out.println(i + " " + j);
                    break;
                }
            }
        }
        return count;
    }

    // Check if substring is present anywhere in scrambled form
    public static boolean scrambledSubstring(String superstring, String substring) {
        int n1 = superstring.length(), n2 = substring.length();

        // Character count for substring
        int[] charCount = new int[26];
        for (char c : substring.toCharArray())
            charCount[c - 'a']++;

        // Check every window of size length(substring)
        for (int i = 0; i <= n1 - n2; i++) {
            int[] count = new int[26];

            // Count characters in current window
            for (int j = i; j < i + n2; j++)
                count[superstring.charAt(j) - 'a']++;

            // If character frequencies match → substring exists
            if (Arrays.equals(charCount, count))
                return true;
        }
        return false;
    }

    // Find most frequent navigation path for each user
    public static String mostFrequentPath(List<String> actions) {

        boolean[] vis = new boolean[actions.size()];
        List<String> paths = new ArrayList<>();

        // Group actions user-wise
        for (int i = 0; i < actions.size(); i++) {

            if (vis[i]) continue;

            String user = actions.get(i).substring(0, 2); // first two chars are username
            String currPath = "";

            // Build path sequence for the user
            for (int j = i; j < actions.size(); j++) {
                if (vis[j]) continue;

                String currUser = actions.get(j).substring(0, 2);
                String currActions = actions.get(j).substring(2);  // full action
                String temp = actions.get(j).substring(4);         // action after prefix

                // Match same user
                if (currUser.equals(user)) {

                    // If previous path exists, add combined path
                    if (!currPath.isEmpty()) {
                        currPath += currActions;
                        paths.add(currPath);
                    }

                    currPath = temp;
                    vis[j] = true;
                }
            }
        }

        int size = paths.size();
        vis = new boolean[size];
        int[] counts = new int[size];
        int maxiCount = 0;

        // Count frequency of each unique path
        for (int i = 0; i < size; i++) {
            if (vis[i]) continue;

            int currCount = 0;

            for (int j = i; j < size; j++) {
                if (vis[j]) continue;

                if (paths.get(i).equals(paths.get(j))) {
                    vis[j] = true;
                    currCount++;
                }
            }

            counts[i] = currCount;
            maxiCount = Math.max(maxiCount, currCount);
        }

        // Choose lexicographically smallest most frequent path
        String journey = "{".repeat(10); // lexicographically large string
        for (int i = 0; i < size; i++) {
            if (counts[i] == maxiCount && paths.get(i).compareTo(journey) < 0) {
                journey = paths.get(i);
            }
        }

        return journey;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("Enter a choice:");
            System.out.println("1. Trend setter:");
            System.out.println("2. Longest balanced subarray:");
            System.out.println("3. Count pairs sum equal to k:");
            System.out.println("4. Scrambled Substring:");
            System.out.println("5. Most frequent path:");
            System.out.println("0. to end:");

            String choice = sc.next();

            switch (choice.charAt(0)) {

                case '1': {
                    System.out.println("Enter size of array and window size:");
                    int size = sc.nextInt(), k = sc.nextInt();
                    System.out.println("Enter elements of array:");

                    List<Integer> nums = new ArrayList<>();
                    for (int i = 0; i < size; i++) nums.add(sc.nextInt());

                    System.out.println("Number of trend setters: " + trendSetter(nums, k));
                    break;
                }

                case '2': {
                    System.out.println("Enter size of array:");
                    int size = sc.nextInt();

                    System.out.println("Enter elements of array:");
                    List<Integer> nums = new ArrayList<>();
                    for (int i = 0; i < size; i++) nums.add(sc.nextInt());

                    System.out.println("Length of longest balanced subarray: " + longestBalanced(nums));
                    break;
                }

                case '3': {
                    System.out.println("Enter size of array and value of k:");
                    int size = sc.nextInt(), k = sc.nextInt();

                    System.out.println("Enter elements of array:");
                    List<Integer> nums = new ArrayList<>();
                    for (int i = 0; i < size; i++) nums.add(sc.nextInt());

                    System.out.println("number of pairs with sum k: " + countPairs(nums, k));
                    break;
                }

                case '4': {
                    System.out.println("Enter superstring:");
                    String superstring = sc.next();

                    System.out.println("Enter substring:");
                    String substring = sc.next();

                    if (scrambledSubstring(superstring, substring))
                        System.out.println("substring is within superstring");
                    else
                        System.out.println("Substring is not within superstring");

                    break;
                }

                case '5': {
                    System.out.println("Enter number of actions:");
                    int size = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    System.out.println("Enter all actions along with user name:");
                    List<String> actions = new ArrayList<>();
                    for (int i = 0; i < size; i++) actions.add(sc.nextLine());

                    System.out.println("Most frequent path: " + mostFrequentPath(actions));
                    break;
                }

                case '0':
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid input please enter again:");
            }
        }

        System.out.println("Thank You");
        sc.close();
    }
}

