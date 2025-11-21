
import java.util.Scanner;

public class Week2Story{

    public static int trendSetter(int[] posts, int k) {
        int trendsetters = 0;
        int n = posts.length;

        for (int i = 0; i <= n - k; i++) {
            int[] counts = new int[k];

            // Count frequencies of each element in the window
            for (int j = 0; j < k; j++) {
                int count = 0;
                for (int idx = 0; idx < k; idx++) {
                    if (posts[i + j] == posts[i + idx]) {
                        count++;
                    }
                }
                counts[j] = count;
            }

            // Find maximum frequency
            int maxFreq = -1;
            for (int j = 0; j < k; j++) {
                if (counts[j] > maxFreq) {
                    maxFreq = counts[j];
                }
            }


            int uniqueWithMax = 0;

            for (int j = 0; j < k; j++) {


                boolean seenBefore = false;
                for (int x = 0; x < j; x++) {
                    if (posts[i + x] == posts[i + j]) {
                        seenBefore = true;
                        break;
                    }
                }
                if (seenBefore) continue;

                if (counts[j] == maxFreq) {
                    uniqueWithMax++;
                }
            }


            if (uniqueWithMax == 1) {
                trendsetters++;
            }
        }

        return trendsetters;
    }


    public static int longestBalanced(int[] nums) {
        int maxLen = 0;
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            int ones = 0, twos = 0;
            for (int j = i; j < size; j++) {
                if (nums[j] == 1) ones++;
                else if (nums[j] == 2) twos++;
                if (ones == twos) {
                    int len = j - i + 1;
                    if (len > maxLen) maxLen = len;
                }
            }
        }

        return maxLen;
    }

    public static int countPairs(int[] nums, int k) {
        int n = nums.length;
        int[] vis = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 1) continue;
            for (int j = i + 1; j < n; j++) {
                if (vis[j] == 1) continue;
                if (nums[i] + nums[j] == k) {
                    vis[i] = 1;
                    vis[j] = 1;
                    count++;
                    System.out.println(i + " " + j);
                    break;
                }
            }
        }

        return count;
    }

    public static boolean scrambledSubstring(String superstring, String substring) {
        int[] charCount = new int[26];
        int[] count = new int[26];
        int n1 = superstring.length();
        int n2 = substring.length();

        for (int i = 0; i < n2; i++) {
            charCount[substring.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= n1 - n2; i++) {
            for (int j = 0; j < 26; j++) count[j] = 0;
            for (int j = i; j < i + n2; j++) {
                count[superstring.charAt(j) - 'a']++;
            }

            boolean match = true;
            for (int j = 0; j < 26; j++) {
                if (charCount[j] != count[j]) {
                    match = false;
                    break;
                }
            }

            if (match) return true;
        }

        return false;
    }

    public static String mostFrequentPath(String[] actions) {
        int n = actions.length;
        int[] vis = new int[n];
        String[] paths = new String[n];
        int pathCount = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == 1) continue;
            String user = actions[i].substring(0, 2);
            String currPath = "";

            for (int j = i; j < n; j++) {
                if (vis[j] == 1) continue;
                String currUser = actions[j].substring(0, 2);
                String currActions = actions[j].substring(2);
                String temp = actions[j].substring(4);

                if (user.equals(currUser)) {
                    if (!currPath.equals("")) {
                        currPath += currActions;
                        paths[pathCount++] = currPath;
                    }
                    currPath = temp;
                    vis[j] = 1;
                }
            }
        }

        int[] counts = new int[pathCount];
        vis = new int[pathCount];
        int maxiCount = 0;
        String journey = "{".repeat(10);

        for (int i = 0; i < pathCount; i++) {
            if (vis[i] == 1) continue;
            int currCount = 0;
            for (int j = i; j < pathCount; j++) {
                if (vis[j] == 1) continue;
                if (paths[i].equals(paths[j])) {
                    vis[i] = 1;
                    vis[j] = 1;
                    currCount++;
                }
            }
            counts[i] = currCount;
            if (currCount > maxiCount) maxiCount = currCount;
        }

        for (int i = 0; i < pathCount; i++) {
            if (counts[i] == maxiCount && paths[i].compareTo(journey) < 0) {
                journey = paths[i];
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
            System.out.println("2. Scrambled Substring:");
            System.out.println("3. Most frequent path:");
            System.out.println("4. Count pairs sum equal to k:");
            System.out.println("5. Longest balanced subarray:");
            System.out.println("0. to end:");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": {
                    System.out.println("Enter size of array and window size:");
                    int size = sc.nextInt(), k = sc.nextInt();
                    int[] nums = new int[size];
                    System.out.println("Enter elements of array:");
                    for (int i = 0; i < size; i++) nums[i] = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Number of trend setters: " + trendSetter(nums, k));
                    break;
                }
                case "5": {
                    System.out.println("Enter size of array:");
                    int size = sc.nextInt();
                    int[] nums = new int[size];
                    System.out.println("Enter elements of array:");
                    for (int i = 0; i < size; i++) nums[i] = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Length of longest balanced subarray: " + longestBalanced(nums));
                    break;
                }
                case "4": {
                    System.out.println("Enter size of array and value of k:");
                    int size = sc.nextInt(), k = sc.nextInt();
                    int[] nums = new int[size];
                    System.out.println("Enter elements of array:");
                    for (int i = 0; i < size; i++) nums[i] = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Number of pairs with sum k: " + countPairs(nums, k));
                    break;
                }
                case "2": {
                    System.out.println("Enter superstring:");
                    String superstring = sc.nextLine();
                    System.out.println("Enter substring:");
                    String substring = sc.nextLine();
                    if (scrambledSubstring(superstring, substring)) {
                        System.out.println("Substring is within superstring");
                    } else {
                        System.out.println("Substring is not within superstring");
                    }
                    break;
                }
                case "3": {
                    System.out.println("Enter number of actions:");
                    int size = Integer.parseInt(sc.nextLine());
                    String[] actions = new String[size];
                    System.out.println("Enter all actions along with user name:");
                    for (int i = 0; i < size; i++) actions[i] = sc.nextLine();
                    System.out.println("Most frequent path: " + mostFrequentPath(actions));
                    break;
                }
                case "0":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input, please enter again:");
            }
        }

        System.out.println("Thank You");
        sc.close();
    }
}
