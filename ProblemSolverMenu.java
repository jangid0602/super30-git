import java.util.Scanner;

public class ProblemSolverMenu {

    //1. find trend setter score
    public int trendSetter(int[] posts, int k) {
        int trendSetters = 0;
        int size = posts.length;

        for (int startIndex = 0; startIndex <= size - k; startIndex++) {
            int[] counts = new int[k];
            int countSize = 0;
            for (int j = startIndex; j < startIndex + k; j++) {
                int counter = 0;
                for (int idx = j; idx < startIndex + k; idx++) {
                    if (posts[idx] == posts[j]) {
                        counter++;
                    }
                }
                if (counter > 0) {
                    counts[countSize] = counter;
                    countSize++;
                }
            }
            int maximum = -1;
            for (int i = 0; i < countSize; i++) {
                if (counts[i] > maximum) maximum = counts[i];
            }
            int frequency = 0;
            for (int i = 0; i < countSize; i++) {
                if (counts[i] == maximum) frequency++;
            }
            if (frequency == 1) trendSetters++;
        }
        return trendSetters;
    }

    //2. find a scrambled substring
    public boolean scrambledSubstring(String superstring, String substring) {
        int n1 = superstring.length();
        int n2 = substring.length();
        int[] charCount = new int[26];
        for (int i = 0; i < n2; i++) {
            charCount[substring.charAt(i) - 'a']++;
        }
        for (int startIndex = 0; startIndex <= n1 - n2; startIndex++) {
            int[] count = new int[26];
            for (int j = startIndex; j < startIndex + n2; j++) {
                count[superstring.charAt(j) - 'a']++;
            }
            boolean same = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] != charCount[i]) {
                    same = false;
                    break;
                }
            }
            if (same) return true;
        }
        return false;
    }

    //3. most frequent user path
    public String mostFrequentPath(String[] actions) {
        int size = actions.length;
        int[] visited = new int[size];
        String[] paths = new String[size];
        int pathSize = 0;
        for (int i = 0; i < size; i++) {
            if (visited[i] == 1) continue;
            String user = "" + actions[i].charAt(0) + actions[i].charAt(1);
            String currentPath = "";
            for (int j = i; j < size; j++) {
                if (visited[j] == 1) continue;
                String currentUser = "" + actions[j].charAt(0) + actions[j].charAt(1);
                if (user.equals(currentUser)) {
                    String fullAction = "";
                    for (int a = 2; a < actions[j].length(); a++) {
                        fullAction += actions[j].charAt(a);
                    }
                    String temp = "";
                    for (int b = 4; b < actions[j].length(); b++) {
                        temp += actions[j].charAt(b);
                    }
                    if (currentPath.length() != 0) {
                        currentPath += fullAction;
                        paths[pathSize] = currentPath;
                        pathSize++;
                    }
                    currentPath = temp;
                    visited[j] = 1;
                }
            }
        }
        int[] counts = new int[pathSize];
        int[] visited2 = new int[pathSize];
        int maxCount = 0;

        for (int i = 0; i < pathSize; i++) {
            if (visited2[i] == 1) continue;
            int currCount = 0;
            for (int j = i; j < pathSize; j++) {
                if (visited2[j] == 1) continue;
                if (paths[i].equals(paths[j])) {
                    visited2[i] = 1;
                    visited2[j] = 1;
                    currCount++;
                }
            }
            counts[i] = currCount;
            if (currCount > maxCount) maxCount = currCount;
        }

        String journey = "{";

        for (int i = 0; i < pathSize; i++) {
            if (counts[i] == maxCount) {
                if (paths[i].compareTo(journey) < 0) {
                    journey = paths[i];
                }
            }
        }
        return journey;
    }

    //4. count pairs that sum to k
    public int countPairs(int[] nums, int k) {
        int size = nums.length;
        int[] visited = new int[size];
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (visited[i] == 1) continue;
            for (int j = i + 1; j < size; j++) {
                if (visited[j] == 1) continue;
                if (nums[i] + nums[j] == k) {
                    visited[i] = 1;
                    visited[j] = 1;
                    count++;
                    System.out.println(i + " " + j);
                    break;
                }
            }
        }
        return count;
    }

    //5.longest balanced subarray
    public int longestBalanced(int[] nums) {
        int size = nums.length;
        int maxLength = 0;

        for (int startIndex = 0; startIndex < size; startIndex++) {
            int ones = 0, twos = 0;
            for (int endIndex = startIndex; endIndex < size; endIndex++) {
                if (nums[endIndex] == 1) ones++;
                else if (nums[endIndex] == 2) twos++;
                if (ones == twos) {
                    int length = endIndex - startIndex + 1;
                    if (length > maxLength) maxLength = length;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

        ProblemSolverMenu Menu = new ProblemSolverMenu();
        Scanner UserInput = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            System.out.println("Enter a choice:");
            System.out.println("1. Find Trendsetter score");
            System.out.println("2. Find a Scrambled Substring");
            System.out.println("3. Most Frequent user path");
            System.out.println("4. Count pairs that sum to K");
            System.out.println("5. Longest Balanced Subarray");
            System.out.println("0. Exit:");

            String choice = UserInput.nextLine();

            if (choice.length() == 0) {
                System.out.println("Your input is wrong!");
                continue;
            }

            switch (choice.charAt(0)) {

                case '1':
                    try {
                        System.out.println("Enter size and window:");
                        int size1 = UserInput.nextInt();
                        int k = UserInput.nextInt();
                        int[] posts = new int[size1];
                        for (int i = 0; i < size1; i++) posts[i] = UserInput.nextInt();
                        System.out.println("Trendsetter score: " + Menu.trendSetter(posts, k));
                    } catch (Exception e) {
                        System.out.println("Your input is wrong!");
                    }
                    UserInput.nextLine();
                    break;

                case '2':
                    System.out.println("Enter superstring:");
                    String superstring = UserInput.nextLine();
                    System.out.println("Enter substring:");
                    String substring = UserInput.nextLine();
                    if (Menu.scrambledSubstring(superstring, substring))
                        System.out.println("Substring is within superstring");
                    else
                        System.out.println("Substring is not within superstring");
                    break;

                case '3':
                    try {
                        System.out.println("Enter number of actions:");
                        int size3 = Integer.parseInt(UserInput.nextLine());
                        String[] actions = new String[size3];
                        for (int i = 0; i < size3; i++) actions[i] = UserInput.nextLine();
                        System.out.println("Most frequent path: " + Menu.mostFrequentPath(actions));
                    } catch (Exception e) {
                        System.out.println("Your input is wrong!");
                    }
                    break;

                case '4':
                    try {
                        System.out.println("Enter size & k:");
                        int size4 = UserInput.nextInt();
                        int k4 = UserInput.nextInt();
                        int[] arr = new int[size4];
                        for (int i = 0; i < size4; i++) arr[i] = UserInput.nextInt();
                        System.out.println("Pairs count: " + Menu.countPairs(arr, k4));
                    } catch (Exception e) {
                        System.out.println("Your input is wrong!");
                    }
                    UserInput.nextLine();
                    break;

                case '5':
                    try {
                        System.out.println("Enter size:");
                        int size5 = UserInput.nextInt();
                        int[] nums2 = new int[size5];
                        for (int i = 0; i < size5; i++) nums2[i] = UserInput.nextInt();
                        System.out.println("Longest Balanced Length: " + Menu.longestBalanced(nums2));
                    } catch (Exception e) {
                        System.out.println("Your input is wrong!");
                    }
                    UserInput.nextLine();
                    break;

                case '0':
                    flag = false;
                    break;

                default:
                    System.out.println("Your input is wrong!");
            }
        }

        System.out.println("Thank You");
        UserInput.close();
    }
}


