import java.util.*;

public class ScrambledSubstring {

    // Function to check if substring exists as an anagram inside superstring
    public static boolean scrambledSubstring(String superStr, String subStr) {

        int n1 = superStr.length();
        int n2 = subStr.length();

        if (n2 > n1) return false;

        int[] charCount = new int[26];

        // Count characters of substring
        for (char ch : subStr.toCharArray()) {
            charCount[ch - 'a']++;
        }

        // Sliding window over superstring
        for (int i = 0; i <= n1 - n2; i++) {
            int[] count = new int[26];

            // Count characters in current window
            for (int j = i; j < i + n2; j++) {
                count[superStr.charAt(j) - 'a']++;
            }

            // If frequency matches → valid anagram found
            if (Arrays.equals(charCount, count)) {
                return true;
            }
        }

        return false;
    }

    // MAIN PROGRAM
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter superstring: ");
        String superStr = sc.nextLine();

        System.out.print("Enter substring: ");
        String subStr = sc.nextLine();

        boolean result = scrambledSubstring(superStr, subStr);

        if (result)
            System.out.println("Substring exists (scrambled match found)");
        else
            System.out.println("Substring does NOT exist");
    }
}
